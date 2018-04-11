package br.com.controle.acesso.database.domain.person;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.controle.acesso.database.domain.person.pk.DocumentPK;

@Entity
@Table(name = "DOCUMENT_TABLE")
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3778151121281696840L;
	
	@EmbeddedId
	private DocumentPK documentPK;
	
	@Column(name="DOCUMENT_NUMBER" , nullable=false , length=20 )
	private String DOCUMENT_NUMBER;

	public DocumentPK getDocumentPK() {
		return documentPK;
	}

	public void setDocumentPK(DocumentPK documentPK) {
		this.documentPK = documentPK;
	}

	public String getDOCUMENT_NUMBER() {
		return DOCUMENT_NUMBER;
	}

	public void setDOCUMENT_NUMBER(String dOCUMENT_NUMBER) {
		DOCUMENT_NUMBER = dOCUMENT_NUMBER;
	}

	public Document(DocumentPK documentPK, String dOCUMENT_NUMBER) {
		super();
		this.documentPK = documentPK;
		DOCUMENT_NUMBER = dOCUMENT_NUMBER;
	}
	
	public Document() {
		
	}
	
	

}
