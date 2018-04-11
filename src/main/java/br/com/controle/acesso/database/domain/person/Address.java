package br.com.controle.acesso.database.domain.person;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import br.com.controle.acesso.database.domain.util.UtilDomain;

@Entity
@Table(name = "ADDRESS_TABLE")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7386260508385134782L;
	@Id
	@TableGenerator(name = "ADDRESS_GENERATOR", table = UtilDomain.TABLE_GENERATOR, pkColumnName = UtilDomain.COLUMN_NAME_GENERATOR, valueColumnName = UtilDomain.COLUMN_VALUE_GENERATOR, pkColumnValue = "ADDRESS_TABLE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ADDRESS_GENERATOR")
	@Column(name = "ADDRESS_ID")
	private Long id;
	
	@Column(name="STREET" , nullable=false , length=80)
	private String street;
	
	@Column(name="ADDRESS_NUMBER" , nullable=false , length=20)
	private String number;
	
	@Column(name="COMPLEMENT" , nullable=false , length=60)
	private String complement;
	
	@Column(name="NEIGHBORHOOD" , nullable=false , length=60)
	private String neighborhood;
	
	@Column(name="CITY" , nullable=false , length=40)
	private String city;
	
	@Column(name="STATE" , nullable=false , length=20)
	private String state;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="PESSOA_ID")
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Address(Long id, String street, String number, String complement, String neighborhood, String city,
			String state) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
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
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	
}
