/**
 * 
 */
package com.ibm.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Ritam
 *
 */
@Component
public class Car {
	
	@Autowired
	private  static Engine engine;	
	
	private String carName;
	
	public void printData(){
		System.out.println(" break name "+this.engine);
	}
	/*public void setEngineproperty(String engineName){
		this.engine.setName(engineName);
	}*/
	

	public String getCarName() {
		return carName;
	}

	
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	/*public void setEngine(Engine engine) {
		this.engine = engine;
	}*/
	//@Autowired
	/*public void setBreak(Break breaks){
		this.engine = new Engine(breaks);
	}*/
	
	
	

}
