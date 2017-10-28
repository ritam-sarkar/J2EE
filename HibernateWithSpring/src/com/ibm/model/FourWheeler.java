/**
 * 
 */
package com.ibm.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Ritam
 *
 */
@Entity
@Table(name = "fourwheeler")
//@DiscriminatorValue(value = "fourwheeler")
public class FourWheeler extends Vehichle{

	@Column(name = "steering")
	private String steering;
	
	

	public FourWheeler(String name, String steering) {
		super(name);
		this.steering = steering;
	}
	

	public FourWheeler() {
		super();
	}


	public String getSteering() {
		return steering;
	}

	public void setSteering(String steering) {
		this.steering = steering;
	}
	
	
}
