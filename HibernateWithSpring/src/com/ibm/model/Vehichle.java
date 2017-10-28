/**
 * 
 */
package com.ibm.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Ritam
 *
 */
@Table(name = "vehichle")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
/*@DiscriminatorColumn(
		name = "vehichle_type",
		discriminatorType = DiscriminatorType.STRING
)*/
public class Vehichle {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "vehichle_name")
	private String name;

	
	public Vehichle(String name) {
		super();
		this.name = name;
	}
	

	public Vehichle() {
		super();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

