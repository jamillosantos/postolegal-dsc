package br.edu.ifrn.postolegal.persistence;

import java.util.Iterator;

public interface Repository<T>
{
	void save(T p);

	void delete(T p);

	Iterator<T> iterator();

}
