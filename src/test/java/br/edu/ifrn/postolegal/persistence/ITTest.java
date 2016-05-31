package br.edu.ifrn.postolegal.persistence;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ITTest<T> extends AbstractTestNGSpringContextTests
{
	protected abstract Repository<T> getRepository();

	protected abstract T createObject();

	@Test
	public void saveOne()
	{
		T object = this.createObject();
		this.getRepository().save(object);
		assertThat(this.getRepository().iterator().next()).isEqualTo(object);
	}

	@Test
	public void deleteOne()
	{
		T object = this.createObject();
		this.getRepository().save(object);
		this.getRepository().delete(object);
		assertThat(this.getRepository().iterator().hasNext()).isFalse();
	}

}
