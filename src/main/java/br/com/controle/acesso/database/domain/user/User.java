package br.com.controle.acesso.database.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.controle.acesso.database.domain.person.Person;

@Entity
@Table(name = "USER_TABLE")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1223704076586113646L;

	@Id
	private Long id;

	@Column(name = "LOGIN_NAME", nullable = false, unique = true, length = 20)
	private String loginName;

	@Column(name = "PASSWORD", nullable = false, length = 20)
	private String password;

	@Column(name = "SITUATION_FLAG", nullable = false, length = 1)
	private Character situationFlag;

	@OneToOne(optional = false)
	@JoinColumn(name = "PERSON_ID")
	@MapsId
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getSituationFlag() {
		return situationFlag;
	}

	public void setSituationFlag(Character situationFlag) {
		this.situationFlag = situationFlag;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public User(Long id, String loginName, String password, Character situationFlag, Person person) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.password = password;
		this.situationFlag = situationFlag;
		this.person = person;
	}

	public User() {
	  super();
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
