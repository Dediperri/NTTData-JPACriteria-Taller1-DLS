package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidad de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author Diego Lopez Strickland
 *
 */
@Entity
@Table(name = "NTTDATA_TH1_CONTRACT")
public class NTTDataContract extends AbstractEntity implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** Identificador PK */
	private Long contractId;

	/** Fecha de vigencia */
	private String startDate;

	/** Fecha de caducidad */
	private String finishDate;

	/** Precio mensual */
	private float monthPrice;

	/** Relacion con el cliente */
	private NTTDataCustomer nttdataCustomer;

	/**
	 * @return the contractNumber
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID")
	public Long getContractId() {
		return contractId;
	}

	/**
	 * @param contractId the contractId to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * @return the startDate
	 */
	@Column(name = "START_DATE", nullable = false)
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the finishDate
	 */
	@Column(name = "FINISH_DATE", nullable = false)
	public String getFinishDate() {
		return finishDate;
	}

	/**
	 * @param finishDate the finishDate to set
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * @return the monthPrice
	 */
	@Column(name = "MONTH_PRICE", nullable = false)
	public float getMonthPrice() {
		return monthPrice;
	}

	/**
	 * @param monthPrice the monthPrice to set
	 */
	public void setMonthPrice(float monthPrice) {
		this.monthPrice = monthPrice;
	}

	/**
	 * @return the nttdataCustomer
	 */
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	public NTTDataCustomer getNttdataCustomer() {
		return nttdataCustomer;
	}

	/**
	 * @param nttdataCustomer the nttdataCustomer to set
	 */
	public void setNttdataCustomer(NTTDataCustomer nttdataCustomer) {
		this.nttdataCustomer = nttdataCustomer;
	}

	/**
	 * @return the class
	 */
	@Transient
	public Class<?> getClase() {
		return NTTDataContract.class;
	}
}
