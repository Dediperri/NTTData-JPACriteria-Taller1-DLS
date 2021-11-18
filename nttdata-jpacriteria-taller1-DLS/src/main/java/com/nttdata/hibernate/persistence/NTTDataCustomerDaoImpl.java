package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * DAO de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author Diego Lopez Strickland
 *
 */

public class NTTDataCustomerDaoImpl extends NTTDataCommonDaoImpl<NTTDataCustomer> implements NTTDataCustomerDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Metodo constructor
	 * 
	 * @param session
	 */
	public NTTDataCustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NTTDataCustomer> searchByNameAndSurnames(String name, String firstSurname, String secondSurname) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		//Creamos la consulta
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NTTDataCustomer> cquery = cb.createQuery(NTTDataCustomer.class);
		final Root<NTTDataCustomer> customer = cquery.from(NTTDataCustomer.class);
		
		//Hacemos los Where
		final Predicate pr1 = cb.like(customer.get("clientName").as(String.class),name);
		final Predicate pr2 = cb.like(customer.get("clientFirstSurname").as(String.class),firstSurname);
		final Predicate pr3 = cb.like(customer.get("clientSecondSurname").as(String.class),secondSurname);
		
		//Realizamos la consulta
		cquery.select(customer).where(cb.and(pr1,pr2,pr3));
		cquery.orderBy(cb.desc(customer.get("clientId")));
		
		//Recogemos la lista del select
		final List<NTTDataCustomer> results = session.createQuery(cquery).getResultList();

		
		return results;

	}

}
