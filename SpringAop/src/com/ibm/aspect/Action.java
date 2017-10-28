/**
 * 
 */
package com.ibm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Ritam
 *
 */
@Component
@Aspect
public class Action {
	
	/*@Before("execution(public String getName())")
	public void firstadvice(){
		System.out.println("first :: before get ");
	}*/
	@Before("onlyEmployee() && allIntGetters()")
	public void secondAdvice(JoinPoint jp){
		System.out.println(" second:: before get of Employee"+jp.toShortString());
	}
		
	@Pointcut("execution(int get*(..))")
	public void allGetters(){
		System.out.println("inside all getters");
	}
	
	@Pointcut("execution(* get*(..))")
	public void allIntGetters(){}
	
	
	@Pointcut("within(com.ibm.model.Student)")
	public void onlyStudent(){}
	
	@Pointcut("within(com.ibm.model.Employee)")
	public void onlyEmployee(){}
	
	/*@Pointcut("execution(int com.ibm.model.Employee.get*(..))")
	public void onlyEmployee(){}*/
}
	

