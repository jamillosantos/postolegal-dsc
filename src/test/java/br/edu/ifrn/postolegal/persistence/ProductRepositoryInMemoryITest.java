package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@IntegrationTest
@TestExecutionListeners(inheritListeners = false, listeners = {
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class })
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
