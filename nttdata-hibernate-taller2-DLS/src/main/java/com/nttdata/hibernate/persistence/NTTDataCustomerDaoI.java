package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * DAO de la tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author Diego Lopez Strickland
 */
public interface NTTDataCustomerDaoI extends NTTDataCommonDaoI<NTTDataCustomer> {

	/**
	 * Localiza los registros dependiendo del nombre y apellidos en BBDD
	 * 
	 * @return List<NTTDataCustomer>
	 */
	public List<NTTDataCustomer> searchByNameAndSurnames(final String name, final String firstSurname, final String secondSurname);
}
