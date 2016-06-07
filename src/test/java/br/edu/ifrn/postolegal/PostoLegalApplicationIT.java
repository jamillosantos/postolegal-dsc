package br.edu.ifrn.postolegal;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
public class PostoLegalApplicationIT extends AbstractTestNGSpringContextTests
{
	@Test
	public void contextLoads()
	{ }
}