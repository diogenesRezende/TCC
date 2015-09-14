package br.com.univas.wsunivas.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDAO<T, PK> {

	protected EntityManager em;

	public GenericDAO(EntityManager em) {

		this.em = em;

	}

	public void salvar(T entity) {

		em.getTransaction().begin();

		em.persist(entity);

		em.getTransaction().commit();

	}

	public void atulizar(T entity) {

		em.getTransaction().begin();

		em.merge(entity);

		em.getTransaction().commit();

	}

	public void deletar(T entity) {

		em.getTransaction().begin();

		em.remove(entity);

		em.getTransaction().commit();

	}

	public T obterPeloId(PK id) {

		@SuppressWarnings(" unchecked ")
		T entity = (T) em.find(getTypeClass(), id);

		return entity;

	}

	@SuppressWarnings(" unchecked ")
	public List<T> obterTodos() {

		Query q = em.createQuery(" from " + getTypeClass().getName(),
				getTypeClass());

		return q.getResultList();

	}

	private Class<?> getTypeClass() {

		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		return clazz;

	}

}
