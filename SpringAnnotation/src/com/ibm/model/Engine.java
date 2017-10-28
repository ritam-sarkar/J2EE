/**
 * 
 */
package com.ibm.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ritam
 *
 */
@Component("e1")
public class Engine {	
	
	private String name;
	
	@Autowired
	private Break breaks;
	
	
	
	public Engine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Engine(Break breaks) {
		super();
		this.breaks = breaks;
	}

	/**
	 * @return the breaks
	 */
	public Break getBreaks() {
		return breaks;
	}

	
	
	

}
