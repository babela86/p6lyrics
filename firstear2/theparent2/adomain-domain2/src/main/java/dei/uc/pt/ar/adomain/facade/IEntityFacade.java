package dei.uc.pt.ar.adomain.facade;

import java.util.Collection;

public interface IEntityFacade<T> {

	T create(T entity);

	T update(T entity);

	void delete(T entity);

	T find(long pk);

	Collection<T> findAll();
}