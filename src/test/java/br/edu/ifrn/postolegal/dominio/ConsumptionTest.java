package br.edu.ifrn.postolegal.dominio;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author renato
 */
@Test
public class ConsumptionTest
{
	private static Date DATE_1;
	private static final Float TOTAL_PAID_1 = 50f;
	private static Vehicle VEHICLE_1;
	private static StationProductHistory HISTORY_1;

	private static Date DATE_2;
	private static final Float TOTAL_PAID_2 = 60f;
	private static Vehicle VEHICLE_2;
	private static StationProductHistory HISTORY_2;

	@BeforeTest
	void initialize()
	{
		Calendar c = Calendar.getInstance();

		Station station = Station.builder().build();
		Product product = Product.builder().build();
		User user = User.builder().build();

		c.set(2016, 02, 23);
		DATE_1 = c.getTime();
		VEHICLE_1 = Vehicle.builder()
			.user(user)
			.build();
		HISTORY_1 = StationProductHistory.builder()
			.product(product)
			.station(station)
			.build();

		c.set(2016, 01, 01);
		DATE_2 = c.getTime();
		VEHICLE_2 = Vehicle.builder()
			.user(user)
			.build();
		HISTORY_2 = StationProductHistory.builder()
			.product(product)
			.station(station)
			.build();
	}

	public void testEquals()
	{
		assertThat(
			Consumption.builder()
				.history(HISTORY_1)
				.vehicle(VEHICLE_1)
				.date(DATE_1)
				.totalPaid(TOTAL_PAID_1)
				.build()
		)
			.isEqualTo(
				Consumption.builder()
					.history(HISTORY_2)
					.vehicle(VEHICLE_2)
					.date(DATE_1)
					.totalPaid(TOTAL_PAID_2)
					.build()
			);
	}

	public void testNotEquals()
	{
		assertThat(
			Consumption.builder()
				.history(HISTORY_1)
				.vehicle(VEHICLE_1)
				.date(DATE_1)
				.totalPaid(TOTAL_PAID_1)
				.build()
		)
			.isNotEqualTo(
				Consumption.builder()
					.history(HISTORY_1)
					.vehicle(VEHICLE_1)
					.date(DATE_2)
					.totalPaid(TOTAL_PAID_1)
					.build()
			);
	}

	public void testCompareTo()
	{
		Consumption c1 =Consumption.builder()
				.history(HISTORY_1)
				.vehicle(VEHICLE_1)
				.date(DATE_1)
				.totalPaid(TOTAL_PAID_1)
				.build();
		Consumption c2 = Consumption.builder()
					.history(HISTORY_2)
					.vehicle(VEHICLE_2)
					.date(DATE_2)
					.totalPaid(TOTAL_PAID_2)
					.build();

		Set<Consumption> consumptions = new TreeSet<Consumption>();
		consumptions.add(c1);
		consumptions.add(c2);
		assertThat(consumptions.iterator().next()).isEqualTo(c2);
	}
}
