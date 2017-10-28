/**
 * 
 *//*
package com.ibm.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.model.Employee;
import com.ibm.model.Student;

*//**
 * @author Ritam
 *
 *//*
public class Client1 {

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/spring-aop.xml");
		Student s = ctx.getBean(Student.class);
		s.setName("abc");
		//System.out.println("student name "+s.getName());
		Employee e = ctx.getBean(Employee.class);
		e.setId(1);
		e.setName("Ritam");
		System.out.println("Employee id"+e.getId());
		System.out.println("Employee name "+e.getName());

	}

}
*/