package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.*;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test(groups = "consumption", dependsOnGroups = {"vehicle", "stationProductHistory"})
public class ConsumptionRepositoryIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private VehicleFactory vehicleFactory;

	@Inject
	private ConsumptionRepository _repository;

	@Inject
	private StationProductHistoryFactory stationProductHistoryFactory;

	@BeforeMethod
	void deleteAll()
	{
		this._repository.deleteAll();
	}

	protected Consumption createObject()
	{
		return Consumption.builder()
			.vehicle(this.vehicleFactory.vehicle())
			.history(this.stationProductHistoryFactory.stationProductHistory())
			.totalPaid(23f)
			.date(new Date())
			.odometer(23f)
			.build();
	}

	public void injection()
	{
		assertThat(this._repository).isNotNull();
	}

	public void deleteOne()
	{
		long count = this._repository.count();
		Consumption object = this.createObject();
		this._repository.save(object);
		assertThat(this._repository.count()).isEqualTo(count + 1);
		this._repository.delete(object);
		assertThat(this._repository.count()).isEqualTo(count);
	}

	public void totalPaid()
	{
		Vehicle v = this.vehicleFactory.vehicle("ZZZ1234");
		this._repository.save(Consumption.builder()
			.vehicle(v)
			.history(this.stationProductHistoryFactory.stationProductHistory())
			.totalPaid(1f)
			.date(Date.from(Instant.now()))
			.odometer(2f)
			.build());
		assertThat(this._repository.sumTotalPaid(v)).isEqualTo(1f);
		this._repository.save(Consumption.builder()
			.vehicle(v)
			.history(this.stationProductHistoryFactory.stationProductHistory())
			.totalPaid(1.5f)
			.date(Date.from(Instant.now()))
			.odometer(4f)
			.build());
		assertThat(this._repository.sumTotalPaid(v)).isEqualTo(2.5f);
		this._repository.deleteAll();
	}
}
