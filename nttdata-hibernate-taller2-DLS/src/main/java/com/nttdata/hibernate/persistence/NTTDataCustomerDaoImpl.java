package com.nttdata.hibernate.persistence;

import java.util.List;

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

		// Localiza clientes en función del nombre y apellidos.
		final List<NTTDataCustomer> customerList = session.createQuery("FROM " + NTTDataCustomer.class.getName() + " WHERE "
				+ "CLIENT_NAME LIKE " + "'" + name + "'" + " AND FIRST_SURNAME LIKE " + "'" + firstSurname + "'"
				+ " AND SECOND_SURNAME LIKE " + "'" + secondSurname + "'").list();

		
		return customerList;

	}

}
