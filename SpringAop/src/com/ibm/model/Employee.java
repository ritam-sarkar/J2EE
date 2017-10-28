/**
 * 
 */
package com.ibm.model;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

import com.ibm.aspect.Loggable;

/**
 * @author Ritam
 *
 */
@Component
public class Employee {
	
		
	private int id;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		//throw new RuntimeException();
	}
	//@Loggable
	public  int getId() {
		//System.out.println("name"+((Employee)AopContext.currentProxy()).getName());
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
