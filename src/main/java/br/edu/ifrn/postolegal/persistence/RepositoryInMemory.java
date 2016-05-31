package br.edu.ifrn.postolegal.persistence;

import java.util.Iterator;
import java.util.Set;

public class RepositoryInMemory<T> implements Repository<T>
{
	private Set<T> objects;

	@Override
	public void save(T p)
	{
            this.objects.add(p);
	}

	@Override
	public void delete(T p)
	{
            this.objects.remove(p);
	}

	@Override
	public Iterator<T> iterator()
	{
            return this.objects.iterator();
	}
}
