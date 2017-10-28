/**
 * 
 */
package com.ibm.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.service.HqlController;
import com.ibm.service.TestController;

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

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		TestController tx = ctx.getBean(TestController.class);
		HqlController hq = ctx.getBean(HqlController.class);
		//tx.display();
		//tx.printPerson();
		//tx.printUserInfo();
		//tx.createCart();
		//tx.printCartInfo();
	    //tx.createPerson();
		//tx.deletePersonById(20);
		//tx.printPerson();
		//tx.printUserInfo();
		//tx.createUser();
		//tx.printUserInfo();		
		//tx.printPerson();
		//tx.createPerson();
		//tx.deletePersonById(9);
		//tx.printPerson();
		//tx.createCart();
		//tx.printCartInfo();
		//tx.printItemInfo();
		//tx.createAddress();
		tx.printaddress();
		//tx.createVehichles();
		
		
		//hq.printShpingDetails();
		//hq.printCacheablePerson();

		
	}

}
