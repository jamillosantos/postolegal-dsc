package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.persistence.Repository;

import java.util.Iterator;

public class Service<T>
{
	private Repository<T> repository;

	public Service(Repository<T> repository)
	{
		this.repository = repository;
	}

	protected void validate(T object) throws Exception
	{ }

	void save(T object) throws Exception
	{
		this.validate(object);
		this.repository.save(object);
	}

	void delete(T object)
	{
		this.repository.delete(object);
	}

	Iterator<T> iterator(T object)
	{
		return this.repository.iterator();
	}
}
