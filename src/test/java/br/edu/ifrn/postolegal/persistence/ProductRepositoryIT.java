package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Product;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test(groups = "product")
public class ProductRepositoryIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private ProductRepository _repository;

	protected Product createObject()
	{
		return Product.builder()
			.title("Gasolina")
			.build();
	}

	@BeforeMethod
	void deleteAll()
	{
		this._repository.deleteAll();
	}

	public void injection()
	{
		assertThat(this._repository).isNotNull();
	}

	public void saveOne()
	{
		long count = this._repository.count();
		Product object = this.createObject();
		this._repository.save(object);
		assertThat(this._repository.count()).isEqualTo(count + 1);
	}

	public void deleteOne()
	{
		long count = this._repository.count();
		Product object = this.createObject();
		this._repository.save(object);
		assertThat(this._repository.count()).isEqualTo(count + 1);
		this._repository.delete(object);
		assertThat(this._repository.count()).isEqualTo(count);
	}
}
