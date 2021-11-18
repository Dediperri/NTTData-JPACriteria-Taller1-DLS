package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Join;

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

		
		//Creamos la consulta
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NTTDataContract> cquery = cb.createQuery(NTTDataContract.class);
		final Root<NTTDataContract> contract = cquery.from(NTTDataContract.class);
		final Join<NTTDataContract, NTTDataCustomer> cusJoinCon = contract.join("nttdataCustomer");
		
		//Hacemos los Where
		final Predicate pr1 = cb.equal(cusJoinCon.<Long> get("clientId"), clientId);
		
		//Realizamos la consulta
		cquery.select(contract).where(cb.and(pr1));
		cquery.orderBy(cb.desc(cusJoinCon.get("clientId")));
		
		//Recogemos la lista del select
		final List<NTTDataContract> results = session.createQuery(cquery).getResultList();
		

		return results;
	}

}
