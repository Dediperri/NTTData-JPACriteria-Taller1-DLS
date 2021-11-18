package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NTTDataCustomer;

/**
 * 
 * Interface del servicio de clientes
 * 
 * @author Diego Lopez Strickland
 *
 */
public interface NTTDataCustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(final NTTDataCustomer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(final NTTDataCustomer updatedCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(final NTTDataCustomer deletedCustomer);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param clientId
	 */
	public NTTDataCustomer searchById(final Long clientId);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<NTTDataCustomer>
	 */
	public List<NTTDataCustomer> searchAll();

	/**
	 * Obtiene todos los clientes con el nombre y apellidos introducidos
	 * 
	 * @return List<NTTDataCustomer>
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 */
	public List<NTTDataCustomer> searchByNameAndSurnames(String name, String firstSurname, String secondSurname);

}
