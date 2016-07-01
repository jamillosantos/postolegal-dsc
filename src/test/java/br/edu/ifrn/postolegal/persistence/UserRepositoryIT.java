package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.User;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test(groups = "user")
public class UserRepositoryIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private UserRepository _repository;

	protected User createObject()
	{
		return User.builder()
			.name("Fulano")
			.email("fulano@fulano.com")
			.password("123456")
			.salt("123456")
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
		User object = this.createObject();
		this._repository.save(object);
		assertThat(this._repository.count()).isEqualTo(count + 1);
	}

	public void deleteOne()
	{
		long count = this._repository.count();
		User object = this.createObject();
		this._repository.save(object);
		assertThat(this._repository.count()).isEqualTo(count + 1);
		this._repository.delete(object);
		assertThat(this._repository.count()).isEqualTo(count);
	}
}
