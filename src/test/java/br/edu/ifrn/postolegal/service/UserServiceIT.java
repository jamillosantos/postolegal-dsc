package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.User;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@Test
/**
 *
 * @author renat
 */
public class UserServiceIT extends AbstractTestNGSpringContextTests
{
	@Inject
	private UserService _service;

	private final String EMAIL_VALID = "email@email01.com";
	private final String NAME_VALID = "Nome 01";
	private final String PASSWORD_VALID = "123456";
	private final String SALT_VALID = "123456";

	@Test
	public void testSave_Success() throws Exception
	{
		long count = this._service.count();
		User object = User.builder()
			.email(EMAIL_VALID)
			.name(NAME_VALID)
			.password(PASSWORD_VALID)
			.salt(SALT_VALID)
			.build();
		this._service.save(object);
		assertThat(this._service.count()).isEqualTo(count + 1);
	}

	// Email
	@Test(expectedExceptions = RequiredException.class)
	public void testSave_EmailNull() throws Exception
	{
		this._service.save(User.builder()
			.name(NAME_VALID)
			.password(PASSWORD_VALID)
			.build());
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_EmailEmpty() throws Exception
	{
		this._service.save(User.builder()
			.email("")
			.name(NAME_VALID)
			.password(PASSWORD_VALID)
			.build());
	}

	/////////////////////// Nome
	@Test(expectedExceptions = RequiredException.class)
	public void testSave_NameNull() throws Exception
	{
		this._service.save(User.builder()
			.email(EMAIL_VALID)
			.password(PASSWORD_VALID)
			.build());
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_NameEmpty() throws Exception
	{
		this._service.save(User.builder()
			.email(EMAIL_VALID)
			.name("")
			.password(PASSWORD_VALID)
			.build());
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_PasswordNull() throws Exception
	{
		this._service.save(User.builder()
			.email(EMAIL_VALID)
			.name(NAME_VALID)
			.build());
	}

	@Test(expectedExceptions = RequiredException.class)
	public void testSave_PasswordEmpty() throws Exception
	{
		this._service.save(User.builder()
			.email(EMAIL_VALID)
			.name(NAME_VALID)
			.password("")
			.build());
	}

	@Test
	public void deleteOne() throws Exception
	{
		long count = this._service.count();
		User object = User.builder()
			.email(EMAIL_VALID)
			.name(NAME_VALID)
			.password(PASSWORD_VALID)
			.salt(SALT_VALID)
			.build();
		this._service.save(object);
		assertThat(this._service.count()).isEqualTo(count + 1);
		this._service.delete(object);
		assertThat(this._service.count()).isEqualTo(count);
	}
}
