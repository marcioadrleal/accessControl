package br.com.controle.acesso.database.domain.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="NATUTAL_PERSON_TABLE")
public class NaturalPerson extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4433601662526367445L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name="DATA_OF_BIRTH", nullable=false)
	private Date dateOfBirth;
	
	@Column(name="GENDER" , length=1 , nullable=false)
	private Character gender;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public NaturalPerson(Long id, String name, String surName, Date currentDate , Date dateOfBirth, Character gender) {
		super(id,name,surName,currentDate);
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	} 
	
	public NaturalPerson() {
	  super();	
	}

}
