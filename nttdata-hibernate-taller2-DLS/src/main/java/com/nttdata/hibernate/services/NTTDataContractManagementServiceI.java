package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NTTDataContract;

/**
 * 
 * Interface del servicio de contratos
 * 
 * @author Diego Lopez Strickland
 *
 */
public interface NTTDataContractManagementServiceI {

	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final NTTDataContract newContract);

	/**
	 * Actualiza un contrato existente.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final NTTDataContract updatedContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final NTTDataContract deletedContract);

	/**
	 * Obtiene un contrato mediante su ID.
	 * 
	 * @param clientId
	 */
	public NTTDataContract searchById(final Long contractId);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<NTTDataCustomer>
	 */
	public List<NTTDataContract> searchAll();
	/**
	 * Localiza los registros dependiendo del clientId
	 * 
	 * @return List<NTTDataContract>
	 */
	public List<NTTDataContract> searchByClientId(final Long clientId);
	
}
