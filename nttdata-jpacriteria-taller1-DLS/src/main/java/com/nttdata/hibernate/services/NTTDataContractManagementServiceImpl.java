package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NTTDataContract;
import com.nttdata.hibernate.persistence.NTTDataContractDaoI;
import com.nttdata.hibernate.persistence.NTTDataContractDaoImpl;
/**
 * 
 * Implementacion del servicio de contratos
 * 
 * @author Diego Lopez Strickland
 *
 */
public class NTTDataContractManagementServiceImpl implements NTTDataContractManagementServiceI {

	/** DAO: NTTDATA_TH1_CONTRACT */
	private NTTDataContractDaoI contractDao;

	/**
	 * Metodo constructor.
	 */
	public NTTDataContractManagementServiceImpl(final Session session) {
		this.contractDao = new NTTDataContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(NTTDataContract newContract) {

		// Verificación de nulidad e inexistencia.
		if (newContract != null && newContract.getContractId() == null) {

			// Insercción del nuevo cliente.
			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(NTTDataContract updatedContract) {

		// Verificación de nulidad y existencia.
		if (updatedContract != null && updatedContract.getContractId() != null) {

			// Actualización del cliente.
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(NTTDataContract deletedContract) {

		// Verificación de nulidad y existencia.
		if (deletedContract != null && deletedContract.getContractId() != null) {

			// Actualización del cliente.
			contractDao.delete(deletedContract);
		}

	}

	@Override
	public NTTDataContract searchById(Long contractId) {

		// Resultado.
		NTTDataContract contract = null;

		// Verificación de nulidad.
		if (contractId != null) {

			// Obtención del cliente por ID.
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}

	@Override
	public List<NTTDataContract> searchAll() {

		// Resultado.
		List<NTTDataContract> contractList = new ArrayList<NTTDataContract>();

		// Obtención de clientes.
		contractList = contractDao.searchAll();

		return contractList;
	}

	@Override
	public List<NTTDataContract> searchByClientId(Long clientId) {

		// Resultado
		List<NTTDataContract> contractList = new ArrayList<NTTDataContract>();

		// Obtencion de los cliente
		contractList = contractDao.searchByClientId(clientId);

		return contractList;

	}

}
