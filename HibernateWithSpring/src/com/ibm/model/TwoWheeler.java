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
@Table(name = "twowheeler")
//@DiscriminatorValue(value = "twowheeler")
public class TwoWheeler extends Vehichle{
	
	@Column(name = "clutch")
	private String clutch;

	
	public TwoWheeler(String name, String clutch) {
		super(name);
		this.clutch = clutch;
	}
	

	public TwoWheeler() {
		super();
	}


	public String getClutch() {
		return clutch;
	}

	public void setClutch(String clutch) {
		this.clutch = clutch;
	}
	

}
