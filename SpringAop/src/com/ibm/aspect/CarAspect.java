/**
 * 
 */
package com.ibm.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Ritam
 *
 */
@Component
@Aspect
public class CarAspect {
	
	@After("carSetter()")
	public void advice(){
		System.out.println("after car get ");
	}
	@Pointcut("execution(* com.ibm.model.Car.get*(..))")
	public void carGetter(){}
	@Pointcut("execution(* com.ibm.model.Car.set*(..))")
	public void carSetter(){}

}
