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
@Table(name="DOCUMENT_TYPE_TABLE")
public class DocumentType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248642122339187543L;
	
	
	@Id
	@TableGenerator(name="DOCUMENT_TYPE_GENERATOR",
    table=UtilDomain.TABLE_GENERATOR ,
    pkColumnName=UtilDomain.COLUMN_NAME_GENERATOR ,
    valueColumnName=UtilDomain.COLUMN_VALUE_GENERATOR ,
    pkColumnValue="DOCUMENT_TYPE",
    allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE,  generator="DOCUMENT_TYPE_GENERATOR")
	@Column(name="DOCTYPE_ID")
	private Integer id;
	
	@Column(name="DOCUMENT_TYPE_CODE" , nullable=false , length=15 , unique=true )
	private String codTypeDocument;
	
	@Column(name="DESCRIPTION_DOCUMENT_TYPE" , nullable=false , length=20 , unique=true)
	private String descriptionDocumentType;
	
	@Column(name="MASK_DOCUMENT_TYPE" , nullable=true , length=20)
	private String maskDocumentType;
	
	public DocumentType() {
		
	}

	public DocumentType(Integer id, String codTypeDocument, String descriptionDocumentType, String maskDocumentType) {
		super();
		this.id = id;
		this.codTypeDocument = codTypeDocument;
		this.descriptionDocumentType = descriptionDocumentType;
		this.maskDocumentType = maskDocumentType;
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
		DocumentType other = (DocumentType) obj;
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

	public String getCodTypeDocument() {
		return codTypeDocument;
	}

	public void setCodTypeDocument(String codTypeDocument) {
		this.codTypeDocument = codTypeDocument;
	}

	public String getDescriptionDocumentType() {
		return descriptionDocumentType;
	}

	public void setDescriptionDocumentType(String descriptionDocumentType) {
		this.descriptionDocumentType = descriptionDocumentType;
	}

	public String getMaskDocumentType() {
		return maskDocumentType;
	}

	public void setMaskDocumentType(String maskDocumentType) {
		this.maskDocumentType = maskDocumentType;
	}
	
	
	

}
