package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.*;
import br.edu.ifrn.postolegal.persistence.DomainFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class ConsumptionServiceIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private ConsumptionService _service;

	private static final Float TOTAL_PAID_VALID = 2.7f;
	private static final Float TOTAL_PAID_INVALID_1 = 0f;
	private static final Float TOTAL_PAID_INVALID_2 = -2.7f;
	private static final float ODOMETER_VALID_1 = 0f;
	private static final float ODOMETER_VALID_2 = 1f;
	private static final float ODOMETER_INVALID_1 = -1;
	private static final Date DATE_VALID = new Date();

	@Inject
	private DomainFactory factory;

	@Test
	public void testSave_Success_1() throws Exception
	{
		this._service.save(
			Consumption.builder()
				.vehicle(this.factory.vehicle())
				.history(this.factory.stationProductHistory())
				.totalPaid(TOTAL_PAID_VALID)
				.date(DATE_VALID)
				.odometer(ODOMETER_VALID_1)
				.build()
		);
	}

	@Test
	public void testSave_Success_2() throws Exception
	{
		this._service.save(
			Consumption.builder()
				.vehicle(this.factory.vehicle())
				.history(this.factory.stationProductHistory())
				.totalPaid(TOTAL_PAID_VALID)
				.date(DATE_VALID)
				.odometer(ODOMETER_VALID_2)
				.build()
		);
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_VehicleNull() throws Exception
	{
		this._service.save(
			Consumption.builder()
				.history(this.factory.stationProductHistory())
				.totalPaid(TOTAL_PAID_VALID)
				.date(DATE_VALID)
				.odometer(ODOMETER_VALID_1)
				.build()
		);
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_HistoryNull() throws Exception
	{
		this._service.save(
			Consumption.builder()
				.vehicle(this.factory.vehicle())
				.totalPaid(TOTAL_PAID_VALID)
				.date(DATE_VALID)
				.odometer(ODOMETER_VALID_1)
				.build()
		);
	}

	@Test(expectedExceptions = BiggerThanZeroException.class)
	public void testSave_TotalPaidInvalidZero() throws Exception
	{
		this._service.save(
			Consumption.builder()
				.vehicle(this.factory.vehicle())
				.history(this.factory.stationProductHistory())
				.totalPaid(TOTAL_PAID_INVALID_1)
				.date(DATE_VALID)
				.odometer(ODOMETER_VALID_1)
				.build()
		);
	}

	@Test(expectedExceptions = BiggerThanZeroException.class)
	public void testSave_TotalPaidInvalidNegative() throws Exception
	{
		this._service.save(
			Consumption.builder()
				.vehicle(this.factory.vehicle())
				.history(this.factory.stationProductHistory())
				.totalPaid(TOTAL_PAID_INVALID_2)
				.date(DATE_VALID)
				.odometer(ODOMETER_VALID_1)
				.build()
		);
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_DateNull() throws Exception
	{
		this._service.save(
			Consumption.builder()
				.vehicle(this.factory.vehicle())
				.history(this.factory.stationProductHistory())
				.totalPaid(TOTAL_PAID_VALID)
				.odometer(ODOMETER_VALID_1)
				.build()
		);
	}

	@Test(expectedExceptions = NonNegativeException.class)
	public void testSave_OdometerNegative() throws Exception
	{
		this._service.save(
			Consumption.builder()
				.vehicle(this.factory.vehicle())
				.history(this.factory.stationProductHistory())
				.totalPaid(TOTAL_PAID_VALID)
				.date(DATE_VALID)
				.odometer(ODOMETER_INVALID_1)
				.build()
		);
	}

	public void testFindAllByVehicle_Success()
	{
		Vehicle vehicle = this.factory.vehicle();
		Consumption consumption = this.factory.consumption(vehicle);
		Iterable<Consumption> it = this._service.findAllByVehiclePlate(vehicle.getLicensePlate());
		assertThat(it.iterator().next().getId()).isEqualTo(consumption.getId());
	}

	@Test
	public void deleteOne() throws Exception
	{
		Consumption object = Consumption.builder()
			.vehicle(this.factory.vehicle())
			.history(this.factory.stationProductHistory())
			.totalPaid(TOTAL_PAID_VALID)
			.date(DATE_VALID)
			.odometer(ODOMETER_VALID_1)
			.build();
		this._service.save(object);
		this._service.delete(object);
		assertThat(this._service.findAll().iterator().hasNext()).isFalse();
	}
}