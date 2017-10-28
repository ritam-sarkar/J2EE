/**
 * 
 */
package com.ibm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Ritam
 *
 */
@Component
//@Aspect
public class AfterAspect {

	//@After("afterSetter()")
	public void firstAdvice(){
		System.out.println("first advice");
	}
	//@After("args(x)")
	public void secondadvice(String x){
		System.out.println("parameter is "+x);
		
	}
	//@AfterReturning(pointcut = "afterGetter()",returning = "x")
	public void thirdAdvice(JoinPoint jp,int x){
		System.out.println("third advice"+jp.toString()+" returning "+x);
	}
	@AfterThrowing(pointcut = "afterSetter()",throwing = "e")
	public void fourthAdvice(JoinPoint jp,RuntimeException e){
		System.out.println("fourth advice "+jp.toString()+" exception "+e);
	}
	
	@Pointcut("execution(public * com.ibm.model.Employee.set*(*))")
	public void afterSetter(){}
	@Pointcut("execution(public * com.ibm.model.Employee.get*(..))")
	public void afterGetter(){}
	
}
