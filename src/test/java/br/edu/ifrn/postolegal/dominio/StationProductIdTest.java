package br.edu.ifrn.postolegal.dominio;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jbull
 * @author J. Santos &lt;jamillo@gmail.com&gt;
 */
@Test
public class StationProductIdTest
{
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
