package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProduct;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@IntegrationTest
@TestExecutionListeners(inheritListeners = false, listeners = {
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class })
public class StationProductServiceTest extends AbstractTestNGSpringContextTests
{
	@Inject
	private StationProductService _service;

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

	@Test
	public void testSave_Success() throws Exception
	{
		this._service.save(
			StationProduct.builder()
				.product(PRODUCT_VALID)
				.station(STATION_VALID)
				.price(PRICE_VALID)
				.build()
		);
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_ProductNull() throws Exception
	{
		this._service.save(
			StationProduct.builder()
				.station(STATION_VALID)
				.price(PRICE_VALID)
				.build()
		);
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_StationNull() throws Exception
	{
		this._service.save(
			StationProduct.builder()
				.product(PRODUCT_VALID)
				.price(PRICE_VALID)
				.build()
		);
	}

	@Test(expectedExceptions = BiggerThanZeroException.class)
	public void testSave_PriceZero() throws Exception
	{
		this._service.save(
			StationProduct.builder()
				.product(PRODUCT_VALID)
				.station(STATION_VALID)
				.price(PRICE_INVALID_1)
				.build()
		);
	}

	@Test(expectedExceptions = BiggerThanZeroException.class)
	public void testSave_PriceNegative() throws Exception
	{
		this._service.save(
			StationProduct.builder()
				.product(PRODUCT_VALID)
				.station(STATION_VALID)
				.price(PRICE_INVALID_2)
				.build()
		);
	}

	@Test
	public void deleteOne() throws Exception
	{
		StationProduct object = StationProduct.builder()
			.product(PRODUCT_VALID)
			.station(STATION_VALID)
			.price(PRICE_VALID)
			.build();
		this._service.save(object);
		this._service.delete(object);
		assertThat(this._service.iterator().hasNext()).isFalse();
	}

}