package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test(groups = "product")
public class ProductServiceIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private ProductService _service;

	private final String TITLE_VALID = "Produto 01";

	@Test
	public void testSave_Success() throws Exception
	{
		long count = this._service.count();
		Product p = Product.builder()
			.title(TITLE_VALID)
			.build();
		this._service.save(p);
		assertThat(this._service.count()).isEqualTo(count + 1);
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_TitleNull() throws Exception
	{
		this._service.save(Product.builder().build());
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_TitleEmpty() throws Exception
	{
		this._service.save(Product.builder()
			.title("")
			.build());
	}

	@Test
	public void deleteOne() throws Exception
	{
		long count = this._service.count();
		Product object = Product.builder()
			.title(TITLE_VALID)
			.build();
		this._service.save(object);
		this._service.delete(object);
		assertThat(this._service.count()).isEqualTo(count);
	}

}