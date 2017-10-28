/**
 * 
 */
package com.ibm.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Ritam
 *
 */
@Component
//@Aspect
public class ArroundAspect {
	
	@Around("allGetter()")
	public Object firstAdvice(ProceedingJoinPoint proceedingJoinPoint){
		Object returnOb = null;
		try {
			System.out.println("first advice :: before ");
			returnOb = proceedingJoinPoint.proceed();			
			System.out.println("first advice :: after retruning");
			return returnOb;
		} catch (Throwable e) {
			//e.printStackTrace();
			System.out.println("first advice :: after throwing"+e+returnOb);
			//returnOb = "Sharmistha";
			//return returnOb;
			
		}
		return returnOb;
	}
	@Pointcut("execution(* get*(..))")
	public void allGetter(){}
	@Pointcut("execution(* set*(..))")
	public void allSetter(){}
	

	//@Around("@annotation(com.ibm.aspect.Loggable)")
	public Object secondAdvice(ProceedingJoinPoint proceedingJoinPoint){
		Object returnOb = null;
		try {
			System.out.println("second advice :: before ");
			returnOb = proceedingJoinPoint.proceed();			
			System.out.println("second advice :: after retruning");
			return returnOb;
		} catch (Throwable e) {
			//e.printStackTrace();
			System.out.println("second advice :: after throwing"+e+returnOb);
			//returnOb = "Sharmistha";
			//return returnOb;
			
		}
		return returnOb;
		
	}
	@Before("@annotation(com.ibm.aspect.Loggable)")
	public void thirdAdvice(){
		System.out.println("tthird advice");
	}
}
