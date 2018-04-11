package br.com.controle.acesso.database.domain.person;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import br.com.controle.acesso.database.domain.util.UtilDomain;

@Entity
@Table(name="PHONE_TYPE_TABLE")
public class TelephoneType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8062989293576093655L;
	
	@Id
	@TableGenerator(name="PHONETYPE_GENERATOR",
    table=UtilDomain.TABLE_GENERATOR ,
    pkColumnName=UtilDomain.COLUMN_NAME_GENERATOR ,
    valueColumnName=UtilDomain.COLUMN_VALUE_GENERATOR ,
    pkColumnValue="PHONETYPE_TABLE",
    allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE,  generator="PHONETYPE_GENERATOR")
	@Column(name="PHONETYPE_ID")
	private Integer id;
	
	@Column(name="DDI_NUMBER" , nullable=false , length=5)
	private String ddi;
	
	@Column(name="PHONE_TYPE" , nullable=false , length=30)
	private String phoneType;
	
	@Column(name="PHONE_MASK" , nullable=false , length=30)
	private String phoneMask;

	public TelephoneType(Integer id, String ddi, String phoneType, String phoneMask) {
		super();
		this.id = id;
		this.ddi = ddi;
		this.phoneType = phoneType;
		this.phoneMask = phoneMask;
	}
	
	public TelephoneType() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TelephoneType other = (TelephoneType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneMask() {
		return phoneMask;
	}

	public void setPhoneMask(String phoneMask) {
		this.phoneMask = phoneMask;
	}
	
	
	
	

}
