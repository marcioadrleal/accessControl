package br.com.controle.acesso.database.domain.person;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import br.com.controle.acesso.database.domain.util.UtilDomain;

@Entity
@Table(name="TELEPHONE_TABLE")
public class Telephone implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8029549834665389122L;

	@Id
	@TableGenerator(name="TELEPHONE_GENERATOR",
    table=UtilDomain.TABLE_GENERATOR ,
    pkColumnName=UtilDomain.COLUMN_NAME_GENERATOR ,
    valueColumnName=UtilDomain.COLUMN_VALUE_GENERATOR ,
    pkColumnValue="TELEPHONE_TABLE",
    allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE,  generator="TELEPHONE_GENERATOR")
	@Column(name="TELEPHONE_ID")
	private Long id;
	
	
	@Column(name="PHONE_NUMBER" , nullable=false , length=30)
	private String phoneNumber;
	
	
	@Column(name="OBSERVATION_DS" , nullable=false , length=30)
	private String ObservationDescription;
	

	@OneToOne(optional=false)
	@JoinColumn(name="PHONETYPE_ID")
	private TelephoneType phoneType;
	

	public Telephone(Long id, String phoneNumber, String observationDescription, TelephoneType phoneType) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		ObservationDescription = observationDescription;
		this.phoneType = phoneType;
	}
	
	public Telephone() {
		
	}

	public Long getId() {
		return id;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getObservationDescription() {
		return ObservationDescription;
	}


	public TelephoneType getPhoneType() {
		return phoneType;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setObservationDescription(String observationDescription) {
		ObservationDescription = observationDescription;
	}

	public void setPhoneType(TelephoneType phoneType) {
		this.phoneType = phoneType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telephone other = (Telephone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
    

}
