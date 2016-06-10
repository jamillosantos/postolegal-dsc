package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class ProductRepositoryIT extends IntegrationTest<Product, Long>
{
	@Inject
	private ProductRepository _repository;

	@Override
	protected CrudRepository<Product, Long> getRepository()
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
