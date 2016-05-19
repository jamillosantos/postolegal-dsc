package br.edu.ifrn.postolegal.dominio;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

/**
 * @author jbull
 */
@Test
public class StationProductTest
{
	private static final Product PRODUCT_1 = Product.builder()
		.id(1l)
		.title("Gasolina")
		.build();
	private static final Station STATION_1 = Station.builder()
		.id(1l)
		.name("Posto IFRN")
		.latitude(1f)
		.longitude(2f)
		.build();
	private static final float PRICE_1 = 2.9f;

	private static final Product PRODUCT_2 = Product.builder()
		.id(2l)
		.title("Álcool")
		.build();
	private static final Station STATION_2 = Station.builder()
		.id(2l)
		.name("Posto Corporativo")
		.latitude(3f)
		.longitude(4f)
		.build();
	private static final float PRICE_2 = 2.95f;

	public void testEquals()
	{
		assertThat(
			StationProduct.builder()
				.product(PRODUCT_1)
				.station(STATION_1)
				.price(PRICE_1)
				.build()
		)
			.isEqualTo(
				StationProduct.builder()
					.product(PRODUCT_1)
					.station(STATION_1)
					.price(PRICE_2)
					.build()
			);
	}

	public void testNotEquals()
	{
		assertThat(
			StationProduct.builder()
				.product(PRODUCT_1)
				.station(STATION_1)
				.price(PRICE_1)
				.build()
		)
			.isNotEqualTo(
				StationProduct.builder()
					.product(PRODUCT_2)
					.station(STATION_2)
					.price(PRICE_1)
					.build()
			);
	}

	public void testCompareTo()
	{
		StationProduct p1 = StationProduct.builder()
			.product(PRODUCT_1)
			.station(STATION_1)
			.price(PRICE_1)
			.build();
		StationProduct p2 = StationProduct.builder()
			.product(PRODUCT_2)
			.station(STATION_1)
			.price(PRICE_2)
			.build();
		StationProduct p3 = StationProduct.builder()
			.product(PRODUCT_1)
			.station(STATION_2)
			.price(PRICE_1)
			.build();
		StationProduct p4 = StationProduct.builder()
			.product(PRODUCT_2)
			.station(STATION_2)
			.price(PRICE_2)
			.build();

		Set<StationProduct> products = new TreeSet<StationProduct>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);

		Iterator<StationProduct> it = products.iterator();
		assertThat(it.next()).isEqualTo(p4);
		assertThat(it.next()).isEqualTo(p3);
		assertThat(it.next()).isEqualTo(p2);
		assertThat(it.next()).isEqualTo(p1);
	}
}
