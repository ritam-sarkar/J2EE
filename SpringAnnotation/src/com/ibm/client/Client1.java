/**
 * 
 */
package com.ibm.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.model.Break;
import com.ibm.model.Car;
import com.ibm.model.Engine;

/**
 * @author Ritam
 *
 */
public class Client1 {

	/**
	 * @param args 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/spring-core.xml");
		Car c = ctx.getBean(Car.class);
		c.setCarName("Audii");		
		c.printData();
		

	}

}
