package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.persistence.Repository;

import java.util.Iterator;

public abstract class Service<T>
{
	private Repository<T> repository;

	public Service(Repository<T> repository)
	{
		this.repository = repository;
	}

	protected void validate(T object) throws ValidationException
	{ }

	public void save(T object) throws Exception
	{
		this.validate(object);
		this.repository.save(object);
	}

	public void delete(T object)
	{
		this.repository.delete(object);
	}

	public Iterator<T> iterator()
	{
		return this.repository.iterator();
	}
}
