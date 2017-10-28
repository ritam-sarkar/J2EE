/**
 * 
 */
package com.ibm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author Ritam
 *
 */
@Embeddable
public class LoginCredential implements Serializable{
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "emailid")
	private String emailId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LoginCredential(int id,String emailId) {
		super();
		this.id = id;
		this.emailId = emailId;
	}

	public LoginCredential() {
		super();
	}
	

}
