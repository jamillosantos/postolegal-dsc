package br.edu.ifrn.postolegal.service;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public abstract class Service<T, ID extends Serializable>
{
	private CrudRepository<T, ID> repository;

	protected CrudRepository<T, ID> getRepository()
	{
		return this.repository;
	}

	public Service(CrudRepository<T, ID> repository)
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

	public Iterable<T> findAll()
	{
		return this.repository.findAll();
	}

	public void deleteAll()
	{
		this.repository.deleteAll();
	}

	public long count()
	{
		return this.repository.count();
	}
}
