package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidad de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author Diego Lopez Strickland
 *
 */

@Entity
@Table(name = "NTTDATA_TH1_CUSTOMER")
public class NTTDataCustomer extends AbstractEntity implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** Identificador PK */
	private Long clientId;

	/** Nombre del cliente */
	private String clientName;

	/** Primer apellido del cliente */
	private String clientFirstSurname;

	/** Segundo apellido del cliente */
	private String clientSecondSurname;

	/** DNI del cliente */
	private String clientDNI;

	/** Contrato del cliente (FK) */
	private List<NTTDataContract> nttdataContract;

	/**
	 * @return the clientId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the clientName
	 */
	@Column(name = "CLIENT_NAME")
	public String getclientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setclientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the clientFirstSurname
	 */
	@Column(name = "FIRST_SURNAME")
	public String getclientFirstSurname() {
		return clientFirstSurname;
	}

	/**
	 * @param clientFirstSurname the clientFirstSurname to set
	 */
	public void setclientFirstSurname(String clientFirstSurname) {
		this.clientFirstSurname = clientFirstSurname;
	}

	/**
	 * @return the clientSecondSurname
	 */
	@Column(name = "SECOND_SURNAME")
	public String getclientSecondSurname() {
		return clientSecondSurname;
	}

	/**
	 * @param clientSecondSurname the clientSecondSurname to set
	 */
	public void setclientSecondSurname(String clientSecondSurname) {
		this.clientSecondSurname = clientSecondSurname;
	}

	/**
	 * @return the clientDNI
	 */
	@Column(name = "CUSTOMER_DNI", unique = true, nullable = true, length = 9)
	public String getClientDNI() {
		return clientDNI;
	}

	/**
	 * @param clientDNI the clientDNI to set
	 */
	public void setClientDNI(String clientDNI) {
		this.clientDNI = clientDNI;
	}

	/**
	 * @return the nttdataContract
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "nttdataCustomer")
	@Column(name = "CONTRACT_ID")
	public List<NTTDataContract> getNttdataContract() {
		return nttdataContract;
	}

	/**
	 * @param nttdataContract the nttdataContract to set
	 */
	public void setNttdataContract(List<NTTDataContract> nttdataContract) {
		this.nttdataContract = nttdataContract;
	}

	/**
	 * @return the class
	 */
	@Transient
	public Class<?> getClase() {
		return NTTDataContract.class;
	}

}
