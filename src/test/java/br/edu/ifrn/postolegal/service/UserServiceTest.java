package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.User;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@IntegrationTest
@TestExecutionListeners(inheritListeners = false, listeners = {
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class })
/**
 *
 * @author renat
 */
public class UserServiceTest extends AbstractTestNGSpringContextTests{
    @Inject
    private UserService _user;
    
    private final String EMAIL_VALID = "email@email01.com";
    private final String NAME_VALID = "nome 01";
    private final String PASSWORD_VALID = "123456";
    
    @Test
    public void testSave_Success() throws Exception
    {
            this._service.save(User.builder()
                    .email(EMAIL_VALID)
                    .build());
            this._service.save(User.builder()
                    .name(NAME_VALID)
                    .build());
            this._service.save(User.builder()
                    .name(PASSWORD_VALID)
                    .build());
    }

    // Email
    @Test(expectedExceptions = RequiredException.class)
    public void testSave_EmailNull() throws Exception
    {
            this._service.save(User.builder().build());
    }

    @Test(expectedExceptions = RequiredException.class)
    public void testSave_EmailEmpty() throws Exception
    {
            this._service.save(User.builder()
                    .email("")
                    .build());
    }

    @Test
    public void deleteOne() throws Exception
    {
            User object = User.builder()
                    .email(EMAIL_VALID)
                    .build();
            this._service.save(object);
            this._service.delete(object);
            assertThat(this._service.iterator().hasNext()).isFalse();
    }
    // [END] Email
    
    /////////////////////// Nome
    @Test(expectedExceptions = RequiredException.class)
    public void testSave_NameNull() throws Exception
    {
            this._service.save(User.builder().build());
    }

    @Test(expectedExceptions = RequiredException.class)
    public void testSave_NameEmpty() throws Exception
    {
            this._service.save(User.builder()
                    .name("")
                    .build());
    }

    @Test
    public void deleteOne() throws Exception
    {
            User object = User.builder()
                    .name(EMAIL_VALID)
                    .build();
            this._service.save(object);
            this._service.delete(object);
            assertThat(this._service.iterator().hasNext()).isFalse();
    }
    //////////////// [END] Nome
    
    /////////////////////// Password
    @Test(expectedExceptions = RequiredException.class)
    public void testSave_PasswordNull() throws Exception
    {
            this._service.save(User.builder().build());
    }

    @Test(expectedExceptions = RequiredException.class)
    public void testSave_PasswordEmpty() throws Exception
    {
            this._service.save(User.builder()
                    .password("")
                    .build());
    }

    @Test
    public void deleteOne() throws Exception
    {
            User object = User.builder()
                    .password(PASSWORD_VALID)
                    .build();
            this._service.save(object);
            this._service.delete(object);
            assertThat(this._service.iterator().hasNext()).isFalse();
    }
    //////////////// [END] Nome
}
