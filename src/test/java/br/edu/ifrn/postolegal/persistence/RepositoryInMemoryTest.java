package br.edu.ifrn.postolegal.persistence;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Model implements Comparable<Model>
{
	@Override
	public int compareTo(Model o)
	{
		return 0;
	}
}

public class RepositoryInMemoryTest
{
	@Test
	public void testSave() throws Exception
	{
		RepositoryInMemory<Model> repo = new RepositoryInMemory<>();
		Model obj = new Model();
		repo.save(obj);
		assertThat(repo.iterator().next()).isEqualTo(obj);
	}

	@Test
	public void testDelete() throws Exception
	{
		RepositoryInMemory<Model> repo = new RepositoryInMemory<>();
		Model obj = new Model();
		repo.save(obj);
		repo.delete(obj);
		assertThat(repo.iterator().hasNext()).isFalse();
	}
}