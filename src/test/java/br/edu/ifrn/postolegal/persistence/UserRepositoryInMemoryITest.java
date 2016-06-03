package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.User;
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
/**
 *
 * @author renato
 */
public class UserRepositoryInMemoryITest extends ITTest<User> {
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
                        .email('fulano@fulano.com')
                        .password('123456')
			.build();
	}
}
