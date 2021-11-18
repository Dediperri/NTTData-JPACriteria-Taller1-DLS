package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * DAO de la tabla NTTDATA_TH1_CONTRACT
 * 
 * @author Diego Lopez Strickland
 */
public interface NTTDataContractDaoI extends NTTDataCommonDaoI<NTTDataContract> {

	/**
	 * Localiza los registros dependiendo del clientId
	 * 
	 * @return List<NTTDataContract>
	 */
	public List<NTTDataContract> searchByClientId(final Long clientId);

}
