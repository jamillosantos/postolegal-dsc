package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProductHistory;
import br.edu.ifrn.postolegal.persistence.ProductFactory;
import br.edu.ifrn.postolegal.persistence.StationFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test(groups = "stationProductHistory", dependsOnGroups = {"product", "station"})
public class StationProductHistoryServiceIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private StationProductHistoryService _service;

	private static final Product PRODUCT_VALID = Product.builder()
		.id(1l)
		.title("Gasolina")
		.build();
	private static final Station STATION_VALID = Station.builder()
		.id(1l)
		.name("Posto IFRN")
		.latitude(1f)
		.longitude(2f)
		.build();
	private static final float PRICE_VALID = 2.9f;
	private static final float PRICE_INVALID_1 = 0;
	private static final float PRICE_INVALID_2 = -2.7f;
	private static final Date DATE_VALID = new Date();

	@Inject
	private ProductFactory productFactory;

	@Inject
	private StationFactory stationFactory;

	@Test
	public void testSave_Success() throws Exception
	{
		long count = this._service.count();
		StationProductHistory h = StationProductHistory.builder()
			.product(this.productFactory.product())
			.station(this.stationFactory.station())
			.price(PRICE_VALID)
			.date(DATE_VALID)
			.build();
		this._service.save(h);
		assertThat(this._service.count()).isEqualTo(count + 1);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testSave_ProductNull() throws Exception
	{
		this._service.save(
			StationProductHistory.builder()
				.station(this.stationFactory.station())
				.price(PRICE_VALID)
				.date(DATE_VALID)
				.build()
		);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testSave_StationNull() throws Exception
	{
		this._service.save(
			StationProductHistory.builder()
				.product(this.productFactory.product())
				.price(PRICE_VALID)
				.date(DATE_VALID)
				.build()
		);
	}

	@Test(expectedExceptions = BiggerThanZeroException.class)
	public void testSave_PriceZero() throws Exception
	{
		this._service.save(
			StationProductHistory.builder()
				.product(this.productFactory.product())
				.station(this.stationFactory.station())
				.price(PRICE_INVALID_1)
				.date(DATE_VALID)
				.build()
		);
	}

	@Test(expectedExceptions = BiggerThanZeroException.class)
	public void testSave_PriceNegative() throws Exception
	{
		this._service.save(
			StationProductHistory.builder()
				.product(this.productFactory.product())
				.station(this.stationFactory.station())
				.price(PRICE_INVALID_2)
				.date(DATE_VALID)
				.build()
		);
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_DateNull() throws Exception
	{
		this._service.save(
			StationProductHistory.builder()
				.product(this.productFactory.product())
				.station(this.stationFactory.station())
				.price(PRICE_VALID)
				.build()
		);
	}

	@Test
	public void deleteOne() throws Exception
	{
		long count = this._service.count();
		StationProductHistory object = StationProductHistory.builder()
			.product(this.productFactory.product())
			.station(this.stationFactory.station())
			.price(PRICE_VALID)
			.date(DATE_VALID)
			.build();
		this._service.save(object);
		this._service.delete(object);
		assertThat(this._service.count()).isEqualTo(count);
	}

}