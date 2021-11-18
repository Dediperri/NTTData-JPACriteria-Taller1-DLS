package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NTTDataCustomer;
import com.nttdata.hibernate.persistence.NTTDataCustomerDaoI;
import com.nttdata.hibernate.persistence.NTTDataCustomerDaoImpl;

/**
 * 
 * Implementación del servicio de clientes
 * 
 * @author Diego Lopez Strickland
 *
 */
public class NTTDataCustomerManagementServiceImpl implements NTTDataCustomerManagementServiceI {

	/** DAO: NTTDATA_TH1_CUSTOMER */
	private NTTDataCustomerDaoI customerDao;

	/**
	 * Metodo constructor.
	 */
	public NTTDataCustomerManagementServiceImpl(final Session session) {
		this.customerDao = new NTTDataCustomerDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(NTTDataCustomer newCustomer) {

		// Verificación de nulidad e inexistencia.
		if (newCustomer != null && newCustomer.getClientId() == null) {

			// Insercción del nuevo cliente.
			customerDao.insert(newCustomer);
		}

	}

	@Override
	public void updateCustomer(NTTDataCustomer updatedCustomer) {
		// Verificación de nulidad y existencia.
		if (updatedCustomer != null && updatedCustomer.getClientId() != null) {

			// Actualización del cliente.
			customerDao.update(updatedCustomer);
		}

	}

	@Override
	public void deleteCustomer(NTTDataCustomer deletedCustomer) {

		// Verificación de nulidad y existencia.
		if (deletedCustomer != null && deletedCustomer.getClientId() != null) {

			// Actualización del cliente.
			customerDao.delete(deletedCustomer);
		}

	}

	@Override
	public NTTDataCustomer searchById(Long clientId) {
		// Resultado.
		NTTDataCustomer customer = null;

		// Verificación de nulidad.
		if (clientId != null) {

			// Obtención del cliente por ID.
			customer = (NTTDataCustomer) customerDao.searchById(clientId);
		}

		return customer;
	}

	@Override
	public List<NTTDataCustomer> searchAll() {

		// Resultado.
		List<NTTDataCustomer> customerList = new ArrayList<NTTDataCustomer>();

		// Obtención de clientes.
		customerList = customerDao.searchAll();

		return customerList;
	}

	@Override
	public List<NTTDataCustomer> searchByNameAndSurnames(String name, String firstSurname, String secondSurname) {

		// Resultado
		List<NTTDataCustomer> customerList = new ArrayList<NTTDataCustomer>();

		// Obtencion de los cliente
		customerList = customerDao.searchByNameAndSurnames(name, firstSurname, secondSurname);

		return customerList;

	}

}
