package br.edu.ifrn.postolegal.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class IntegrationTest<T, ID extends Serializable> extends AbstractTestNGSpringContextTests
{
	protected abstract CrudRepository<T, ID> getRepository();

	protected abstract T createObject();

	@Test
	public void testInjection()
	{
		assertThat(this.getRepository()).isNotNull();
	}

	@Test
	public void testSaveOne()
	{
		long count = this.getRepository().count();
		T object = this.createObject();
		this.getRepository().save(object);
		assertThat(this.getRepository().count()).isEqualTo(count + 1);
	}

	@Test
	public void testDeleteOne()
	{
		long count = this.getRepository().count();
		T object = this.createObject();
		this.getRepository().save(object);
		assertThat(this.getRepository().count()).isEqualTo(count + 1);
		this.getRepository().delete(object);
		assertThat(this.getRepository().count()).isEqualTo(count);
	}

}
