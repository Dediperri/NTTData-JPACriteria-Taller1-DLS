package com.nttdata.hibernate;

import java.util.Date;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NTTDataContract;
import com.nttdata.hibernate.persistence.NTTDataCustomer;
import com.nttdata.hibernate.services.NTTDataContractManagementServiceImpl;
import com.nttdata.hibernate.services.NTTDataCustomerManagementServiceImpl;

/**
 * Clase main del proyecto
 *
 * @author Diego Lopez Strickland
 */
public class NTTDataHibernateMainT2 {

	/**
	 * Metodo main de mi clase NTTDataHibernateMainT2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final NTTDataCustomerManagementServiceImpl customerService = new NTTDataCustomerManagementServiceImpl(session);
		final NTTDataContractManagementServiceImpl contractService = new NTTDataContractManagementServiceImpl(session);

		// Auditoría.
		final String updatedUser = "NTTDATAService_SYS";
		final Date updatedDate = new Date();

		// Generación de clientes.
		final NTTDataCustomer cliente1 = new NTTDataCustomer();
		cliente1.setclientName("Diego");
		cliente1.setclientFirstSurname("Lopez");
		cliente1.setclientSecondSurname("Strickland");
		cliente1.setClientDNI("77943441Y");
		cliente1.setUpdatedUser(updatedUser);
		cliente1.setUpdatedDate(updatedDate);

		final NTTDataCustomer cliente2 = new NTTDataCustomer();
		cliente2.setclientName("Fatima");
		cliente2.setclientFirstSurname("Prieto");
		cliente2.setclientSecondSurname("Alvear");
		cliente2.setClientDNI("36943321Y");
		cliente2.setUpdatedUser(updatedUser);
		cliente2.setUpdatedDate(updatedDate);

		final NTTDataCustomer cliente3 = new NTTDataCustomer();
		cliente3.setclientName("Juan Luis");
		cliente3.setclientFirstSurname("Almeida");
		cliente3.setclientSecondSurname("Munoz");
		cliente3.setClientDNI("48574839I");
		cliente3.setUpdatedUser(updatedUser);
		cliente3.setUpdatedDate(updatedDate);

		// Generacion de contratos
		final NTTDataContract contrato1 = new NTTDataContract();
		contrato1.setStartDate("20/11/2021");
		contrato1.setFinishDate("20/11/2022");
		contrato1.setMonthPrice(400.34f);
		contrato1.setNttdataCustomer(cliente1);
		contrato1.setUpdatedUser(updatedUser);
		contrato1.setUpdatedDate(updatedDate);

		final NTTDataContract contrato2 = new NTTDataContract();
		contrato2.setStartDate("1/01/2022");
		contrato2.setFinishDate("1/01/2023");
		contrato2.setMonthPrice(209f);
		contrato2.setNttdataCustomer(cliente2);
		contrato2.setUpdatedUser(updatedUser);
		contrato2.setUpdatedDate(updatedDate);

		final NTTDataContract contrato3 = new NTTDataContract();
		contrato3.setStartDate("13/12/2021");
		contrato3.setFinishDate("13/12/2022");
		contrato3.setMonthPrice(809.81f);
		contrato3.setNttdataCustomer(cliente2);
		contrato3.setUpdatedUser(updatedUser);
		contrato3.setUpdatedDate(updatedDate);

		// Insertar los clientes
		customerService.insertNewCustomer(cliente1);
		customerService.insertNewCustomer(cliente2);
		customerService.insertNewCustomer(cliente3);

		// Insertar los contratos
		contractService.insertNewContract(contrato1);
		contractService.insertNewContract(contrato2);
		contractService.insertNewContract(contrato3);

		// Hago un update de el cliente 2 y 3
		cliente2.setclientName("Maria");
		cliente2.setClientDNI("36943781Y");
		cliente3.setclientName("Angel Luis");

		customerService.updateCustomer(cliente2);
		customerService.updateCustomer(cliente3);

		// Por ultimo borro el cliente 2
		customerService.deleteCustomer(cliente2);

		// Y borro el contrato 3
		contractService.deleteContract(contrato3);

		// Imprimo por consola el dni del cliente 3
		System.out.println(customerService.searchByNameAndSurnames(cliente3.getclientName(),
				cliente3.getclientFirstSurname(), cliente3.getclientSecondSurname()).get(0).getClientDNI());

		// Imprimo por consola el dni del cliente que tiene asociado un contrato
		System.out.println(
				contractService.searchByClientId(cliente2.getClientId()).get(0).getNttdataCustomer().getClientDNI());
		// Cierre de sesión.
		session.close();

	}
}
