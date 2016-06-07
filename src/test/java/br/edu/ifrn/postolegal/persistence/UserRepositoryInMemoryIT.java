package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.User;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
public class UserRepositoryInMemoryIT extends ITAbstract<User>
{
	@Inject
	private UserRepository _repository;

	@Override
	protected Repository<User> getRepository()
	{
		return this._repository;
	}

	@Override
	protected User createObject()
	{
		return User.builder()
			.name("Fulano")
			.email("fulano@fulano.com")
			.password("123456")
			.build();
	}
}
