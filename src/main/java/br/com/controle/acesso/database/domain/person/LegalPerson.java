package br.com.controle.acesso.database.domain.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="LEGAL_PERSON_TABLE")
public class LegalPerson extends Person {
	
   
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8951882044245916000L;
	
	@Column(name="COMPANY_TYPE",length=40)
	private String companyType;
	
	@Column(name="COMPANY_SIZE",length=20)
	private String companySize; 
	
	@Column(name="LEGAL_NATURE",length=60)
	private String legalNature;
	
	@Column(name="PRIMARY_CNAE_COD",length=10)
	private String primaryCnaeCod;
	
	@Column(name="SECONDARY_CNAE_COD",length=10)
	private String secondaryCnaeCod;
	
	@Column(name="PRIMARY_CNAE_DESC",length=60)
	private String primaryCnaeDescription;
	
	@Column(name="SECONDARY_CNAE_DESC",length=60)
	private String secondaryCnaeDescription;
	
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name="OPENING_DATE")
	private Date openingDate;


	public String getCompanyType() {
		return companyType;
	}


	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}


	public String getCompanySize() {
		return companySize;
	}


	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}


	public String getLegalNature() {
		return legalNature;
	}


	public void setLegalNature(String legalNature) {
		this.legalNature = legalNature;
	}


	public String getPrimaryCnaeCod() {
		return primaryCnaeCod;
	}


	public void setPrimaryCnaeCod(String primaryCnaeCod) {
		this.primaryCnaeCod = primaryCnaeCod;
	}


	public String getSecondaryCnaeCod() {
		return secondaryCnaeCod;
	}


	public void setSecondaryCnaeCod(String secondaryCnaeCod) {
		this.secondaryCnaeCod = secondaryCnaeCod;
	}


	public String getPrimaryCnaeDescription() {
		return primaryCnaeDescription;
	}


	public void setPrimaryCnaeDescription(String primaryCnaeDescription) {
		this.primaryCnaeDescription = primaryCnaeDescription;
	}


	public String getSecondaryCnaeDescription() {
		return secondaryCnaeDescription;
	}


	public void setSecondaryCnaeDescription(String secondaryCnaeDescription) {
		this.secondaryCnaeDescription = secondaryCnaeDescription;
	}


	public Date getOpeningDate() {
		return openingDate;
	}


	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}


	public LegalPerson(Long id, String name, String surName, Date currentDate , String companyType, String companySize, String legalNature, String primaryCnaeCod,
			String secondaryCnaeCod, String primaryCnaeDescription, String secondaryCnaeDescription, Date openingDate) {
		super( id, name, surName, currentDate);
		this.companyType = companyType;
		this.companySize = companySize;
		this.legalNature = legalNature;
		this.primaryCnaeCod = primaryCnaeCod;
		this.secondaryCnaeCod = secondaryCnaeCod;
		this.primaryCnaeDescription = primaryCnaeDescription;
		this.secondaryCnaeDescription = secondaryCnaeDescription;
		this.openingDate = openingDate;
	}
	
	public LegalPerson() {
	  super();
	}
	

}
