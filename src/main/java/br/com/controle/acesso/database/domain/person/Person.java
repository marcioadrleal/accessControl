package br.com.controle.acesso.database.domain.person;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.controle.acesso.database.domain.util.UtilDomain;


@Entity
@Table(name="PERSON_TABLE")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -84853131713922071L;

	
	@Id
	@TableGenerator(name="PERSON_GENERATOR",
    table=UtilDomain.TABLE_GENERATOR ,
    pkColumnName=UtilDomain.COLUMN_NAME_GENERATOR ,
    valueColumnName=UtilDomain.COLUMN_VALUE_GENERATOR ,
    pkColumnValue="PERSON_TABLE",
    allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE,  generator="PERSON_GENERATOR")
	@Column(name="PERSON_ID")
	private Long id;
	
	@Column(name="NAME" , nullable=false , length=120 )
	private String name;
	
	@Column(name="SURNAME" , nullable=false , length=120 )
	private String surName;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Column(name="SAVE_DATE" , nullable=false )
	private Date currentDate;
	
	@ElementCollection
	@CollectionTable(name="EMAIL_TABLE")
	private Set<String> emails = new HashSet<>();
	
	
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL,targetEntity=br.com.controle.acesso.database.domain.person.Address.class)
	private List<Address> people;
	
	
	@OneToMany(mappedBy="documentPK.person",cascade=CascadeType.ALL,targetEntity=br.com.controle.acesso.database.domain.person.Document.class)
	private List<Document> documents;
	
	
    public Person() {
    	
    }
	
	public Person(Long id, String name, String surName, Date currentDate) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.currentDate = currentDate;
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}


	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}
	
	
	
	
	
}
