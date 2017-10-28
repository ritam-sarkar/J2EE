/**
 * 
 */
package com.ibm.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.model.Employee;
import com.ibm.model.Student;

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
		/*Employee e1 =ctx.getBean("e1",Employee.class);
		Employee e2 =ctx.getBean("e2",Employee.class);
		System.out.println(e1);
		System.out.println(e2.getEmails());*/
		Student s = ctx.getBean("s2",Student.class);
		System.out.println("Student >> "+s);
		System.out.println(s.getSingleAddress().getLocation());
		Student s5 = ctx.getBean("s5",Student.class);
		System.out.println(s5.getSingleAddress().getLocation());
        		
		
		
		
	}

}
