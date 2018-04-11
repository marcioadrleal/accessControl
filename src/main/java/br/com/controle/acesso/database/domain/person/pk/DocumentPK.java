package br.com.controle.acesso.database.domain.person.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.controle.acesso.database.domain.person.DocumentType;
import br.com.controle.acesso.database.domain.person.Person;
import br.com.controle.acesso.database.domain.person.enums.PersonTypeEnum;

@Embeddable
public class DocumentPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1496147785042150336L;

	@ManyToOne(optional=false)
	@JoinColumn(name="PERSON_ID")
	private Person person;
	
	@OneToOne(optional=false)
	@JoinColumn(name="DOCUMENT_TYPE_ID")
  	private DocumentType documentType;
	
	@Column(name="PERSON_TYPE" , nullable=false)
	private Integer personType;
	
	public DocumentPK() {
		
	}
	

	public DocumentPK(Person person, DocumentType documentType , PersonTypeEnum personType ) {
		super();
		this.person = person;
		this.documentType = documentType;
		this.personType = personType == null ? null : personType.getCod();
	}

	
	public PersonTypeEnum getPersonType() {
		return PersonTypeEnum.toEnum(personType);
	}


	public void setPersonType(PersonTypeEnum personType) {
		this.personType = personType == null ? null : personType.getCod();
	}


	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	
	
	
	

}
