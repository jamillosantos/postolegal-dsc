package br.edu.ifrn.postolegal.domain;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class StationProductIdTest
{
	/*
private static final Product PRODUCT_1 = Product.builder()
	.title("Gasolina")
	.build();
private static final Station STATION_1 = Station.builder()
	.name("Posto 01")
	.latitude(1.1f)
	.longitude(1.2f)
	.build();
private static final Product PRODUCT_2 = Product.builder()
	.title("Gás Natural")
	.build();
private static final Station STATION_2 = Station.builder()
	.name("Posto 02")
	.latitude(1.3f)
	.longitude(1.4f)
	.build();
*/
	private static final long PRODUCT_1 = 1;
	private static final long STATION_1 = 1;
	private static final long PRODUCT_2 = 2;
	private static final long STATION_2 = 2;

	public void testEquals()
	{
		assertThat(
			StationProductId.builder()
				.productId(PRODUCT_1)
				.stationId(STATION_1)
				.build()
		)
			.isEqualTo(
				StationProductId.builder()
					.productId(PRODUCT_1)
					.stationId(STATION_1)
					.build()
			);
	}

	public void testNotEqualsProductIdDiff()
	{
		assertThat(
			StationProductId.builder()
				.productId(PRODUCT_1)
				.stationId(STATION_1)
				.build()
		)
			.isNotEqualTo(
				StationProductId.builder()
					.productId(PRODUCT_2)
					.stationId(STATION_1)
					.build()
			);
	}

	public void testNotEqualsStationIdDiff()
	{
		assertThat(
			StationProductId.builder()
				.productId(PRODUCT_1)
				.stationId(STATION_1)
				.build()
		)
			.isNotEqualTo(
				StationProductId.builder()
					.productId(PRODUCT_1)
					.stationId(STATION_2)
					.build()
			);
	}
}
