package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional(readOnly = true)
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

	@Transactional
	public void save(T object) throws Exception
	{
		this.validate(object);
		this.repository.save(object);
	}

	@Transactional
	public void delete(T object)
	{
		this.repository.delete(object);
	}

	public Iterable<T> findAll()
	{
		return this.repository.findAll();
	}

	@Transactional
	public void deleteAll()
	{
		this.repository.deleteAll();
	}

	public long count()
	{
		return this.repository.count();
	}

	public T findOne(ID id)
	{
		return this.repository.findOne(id);
	}
}
