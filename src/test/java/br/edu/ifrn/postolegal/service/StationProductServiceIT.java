package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProduct;
import br.edu.ifrn.postolegal.persistence.DomainFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class StationProductServiceIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private StationProductService _service;

	@Inject
	private DomainFactory factory;

	private static final float PRICE_VALID = 2.9f;
	private static final float PRICE_INVALID_1 = 0;
	private static final float PRICE_INVALID_2 = -2.7f;

	@Test
	public void testSave_Success() throws Exception
	{
		long count = this._service.count();
		StationProduct s = StationProduct.builder()
			.product(this.factory.product())
			.station(this.factory.station())
			.price(PRICE_VALID)
			.build();
		this._service.save(s);
		assertThat(this._service.count()).isEqualTo(count + 1);
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_ProductNull() throws Exception
	{
		this._service.save(
			StationProduct.builder()
				.station(this.factory.station())
				.price(PRICE_VALID)
				.build()
		);
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_StationNull() throws Exception
	{
		this._service.save(
			StationProduct.builder()
				.product(this.factory.product())
				.price(PRICE_VALID)
				.build()
		);
	}

	@Test(expectedExceptions = BiggerThanZeroException.class)
	public void testSave_PriceZero() throws Exception
	{
		this._service.save(
			StationProduct.builder()
				.product(this.factory.product())
				.station(this.factory.station())
				.price(PRICE_INVALID_1)
				.build()
		);
	}

	@Test(expectedExceptions = BiggerThanZeroException.class)
	public void testSave_PriceNegative() throws Exception
	{
		this._service.save(
			StationProduct.builder()
				.product(this.factory.product())
				.station(this.factory.station())
				.price(PRICE_INVALID_2)
				.build()
		);
	}

	@Test
	public void deleteOne() throws Exception
	{
		long count = this._service.count();
		StationProduct object = StationProduct.builder()
			.product(this.factory.product())
			.station(this.factory.station())
			.price(PRICE_VALID)
			.build();
		this._service.save(object);
		this._service.delete(object);
		assertThat(this._service.count()).isEqualTo(count);
	}

}