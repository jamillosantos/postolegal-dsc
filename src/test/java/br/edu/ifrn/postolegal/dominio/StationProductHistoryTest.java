package br.edu.ifrn.postolegal.dominio;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jbull
 * @author J. Santos &lt;jamillo@gmail.com&gt;
 */
@Test
public class StationProductHistoryTest
{
	private static final long ID_1 = 1;

	private static final Product PRODUCT_1 = Product.builder()
		.title("Gasolina")
		.build();
	private static final Station STATION_1 = Station.builder()
		.id(1l)
		.name("Posto IFRN")
		.build();
	private static Date DATE_1;
	private static final float PRICE_1 = 2.9f;

	private static final long ID_2 = 2;
	private static final Product PRODUCT_2 = Product.builder()
		.title("Álcool")
		.build();
	private static final Station STATION_2 = Station.builder()
		.id(2l)
		.name("Posto Corporativo")
		.build();
	private static Date DATE_2;
	private static final float PRICE_2 = 2.95f;

	@BeforeTest
	public void initialize()
	{
		Calendar c1 = Calendar.getInstance();

		c1.set(2016, 06, 02, 12, 51, 03);
		DATE_1 = c1.getTime();

		Calendar c2 = Calendar.getInstance();
		c2.set(2016, 01, 29, 13, 28, 59);
		DATE_2 = c2.getTime();
	}

	public void testEquals()
	{
		assertThat(
			StationProductHistory.builder()
				.id(ID_1)
				.product(PRODUCT_1)
				.station(STATION_1)
				.price(PRICE_1)
				.date(DATE_1)
				.build()
		)
			.isEqualTo(
				StationProductHistory.builder()
					.id(ID_1)
					.product(PRODUCT_2)
					.station(STATION_2)
					.price(PRICE_2)
					.date(DATE_2)
					.build()
			);
	}

	public void testNotEquals()
	{
		assertThat(
			StationProductHistory.builder()
				.id(ID_1)
				.product(PRODUCT_1)
				.station(STATION_1)
				.price(PRICE_1)
				.date(DATE_1)
				.build()
		)
			.isNotEqualTo(
				StationProductHistory.builder()
					.id(ID_2)
					.product(PRODUCT_1)
					.station(STATION_1)
					.price(PRICE_1)
					.date(DATE_1)
					.build()
			);
	}

	public void testCompareTo()
	{
		StationProductHistory h1 = StationProductHistory.builder()
			.id(ID_1)
			.product(PRODUCT_1)
			.station(STATION_1)
			.price(PRICE_1)
			.date(DATE_1)
			.build();
		StationProductHistory h2 = StationProductHistory.builder()
			.id(ID_2)
			.product(PRODUCT_1)
			.station(STATION_1)
			.price(PRICE_2)
			.date(DATE_2)
			.build();

		Set<StationProductHistory> history = new TreeSet<StationProductHistory>();
		history.add(h1);
		history.add(h2);
		assertThat(history.iterator().next()).isEqualTo(h2);
	}
}