package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class ProductRepositoryInMemoryITest extends ITTest<Product>
{
	@Inject
	private ProductRepository _repository;

	@Override
	protected Repository<Product> getRepository()
	{
		return this._repository;
	}

	@Override
	protected Product createObject()
	{
		return Product.builder()
			.title("Gasolina")
			.build();
	}
}
