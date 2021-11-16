package com.nttdata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * 
 * DAO generico
 * 
 * @author Diego Lopez Strickland
 *
 */
public class NTTDataCommonDaoImpl<T extends AbstractEntity> implements NTTDataCommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Metodo constructor
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public NTTDataCommonDaoImpl(Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(final T paramT) {
		// Verificaion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserccion
		session.save(paramT);
		session.flush();

		// Commit
		session.getTransaction().commit();
	}

	@Override
	public void update(T paramT) {

		// Verificaion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Actualizacion
		session.saveOrUpdate(paramT);

		// Commit
		session.getTransaction().commit();

	}

	@Override
	public void delete(T paramT) {

		// Verificaion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Borrado
		session.delete(paramT);

		// Commit
		session.getTransaction().commit();

	}

	@Override
	public T searchById(Long id) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por PK.
		T result = (T) session.get(this.entityClass, id);

		return result;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		return list;

	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
