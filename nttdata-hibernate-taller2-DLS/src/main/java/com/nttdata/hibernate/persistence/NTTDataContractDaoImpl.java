package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * DAO de tabla NTTDATA_TH1_CONTRACT
 * 
 * @author Diego Lopez Strickland
 *
 */
public class NTTDataContractDaoImpl extends NTTDataCommonDaoImpl<NTTDataContract> implements NTTDataContractDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Metodo constructor
	 * 
	 * @param session
	 */
	public NTTDataContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<NTTDataContract> searchByClientId(Long clientId) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza contratos en función del id de cliente.
		@SuppressWarnings("unchecked")
		final List<NTTDataContract> contractList = session
				.createQuery("FROM " + NTTDataContract.class.getName() + " WHERE CLIENT_ID = " + clientId).list();

		return contractList;
	}

}
