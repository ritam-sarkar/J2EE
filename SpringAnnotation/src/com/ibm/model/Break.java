/**
 * 
 */
package com.ibm.model;

import org.springframework.stereotype.Component;

/**
 * @author Ritam
 *
 */
@Component("b")
public class Break {
	private String name;

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

}
