/**
 * 
 */
package com.ibm.model;

import java.util.Date;

import javax.persistence.Cacheable;

/**
 * @author Ritam
 *
 */

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Ritam
 *
 */
@Entity
@Table(name="person")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Person {

	/*@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	*/
	@EmbeddedId
	LoginCredential loginId;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "city")
	private String city;
	
	@Transient
	//@Column(name = "lastname")	
	private String lastname;
	
	//@Lob
	//@Type(type = "text")
	@Column(name = "description")
	private String descripton;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private Date birthDate;
	

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/*@Override
	public String toString(){
		String s= "person >> "+this.getId()+" | "+this.getFirstname()+" | "+this.getLastname()+" | "+this.getCity()+"| "+this.descripton+" | "+this.birthDate;
		return s;
	}*/

	public LoginCredential getLoginId() {
		return loginId;
	}

	public void setLoginId(LoginCredential loginId) {
		this.loginId = loginId;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString(){
		String s= "person >> "+this.loginId.getId()+" | "+this.loginId.getEmailId() +" | "+this.getFirstname()+" | "+this.getLastname()+" | "+this.getCity()+"| "+this.descripton+" | "+this.birthDate;
		return s;
	}
	
	public Person(String firstname, String city, String lastname,String description,Date birthDate) {
		super();
		this.firstname = firstname;
		this.city = city;
		this.lastname = lastname;
		this.birthDate = birthDate;
		this.descripton = description;
	}

	public Person() {
		super();
	}
	
	
		
	
}

