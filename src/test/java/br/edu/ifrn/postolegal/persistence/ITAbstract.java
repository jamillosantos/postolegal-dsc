package br.edu.ifrn.postolegal.persistence;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ITAbstract<T> extends AbstractTestNGSpringContextTests
{
	protected abstract Repository<T> getRepository();

	protected abstract T createObject();

	@Test
	public void testInjection()
	{
		assertThat(this.getRepository()).isNotNull();
	}

	@Test
	public void testSaveOne()
	{
		T object = this.createObject();
		this.getRepository().save(object);
		assertThat(this.getRepository().iterator().next()).isEqualTo(object);
	}

	@Test
	public void testDeleteOne()
	{
		// Clean all possible
		while (this.getRepository().iterator().hasNext())
			this.getRepository().delete(this.getRepository().iterator().next());
		//
		T object = this.createObject();
		this.getRepository().save(object);
		this.getRepository().delete(object);
		assertThat(this.getRepository().iterator().hasNext()).isFalse();
	}

}
