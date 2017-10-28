/**
 * 
 */
package com.ibm.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.Joinpoint;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import com.ibm.model.Customer;



/**
 * @author Ritam
 *
 */
@Component("customerAdvice")
public class CustomerAdvice implements MethodBeforeAdvice,AfterReturningAdvice,MethodInterceptor{

	private final Object throwsAdvice = null;
	private final Map<Class<?>, Method> exceptionHandlerMap = new HashMap<>();
	/**
	 * Callback before a given method is invoked.
	 * @param method method being invoked
	 * @param args arguments to the method
	 * @param target target of the method invocation. May be {@code null}.
	 * @throws Throwable if this object wishes to abort the call.
	 * Any exception thrown will be returned to the caller if it's
	 * allowed by the method signature. Otherwise the exception
	 * will be wrapped as a runtime exception.
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		Object n = args.length>0?args[0]:null;
		System.out.println("advice runs before method "+method.getName()+" "+n);
		((Customer)target).bar();
	}

	
	/**
	 * Callback after a given method successfully returned.
	 * @param returnValue the value returned by the method, if any
	 * @param method method being invoked
	 * @param args arguments to the method
	 * @param target target of the method invocation. May be {@code null}.
	 * @throws Throwable if this object wishes to abort the call.
	 * Any exception thrown will be returned to the caller if it's
	 * allowed by the method signature. Otherwise the exception
	 * will be wrapped as a runtime exception.
	 */
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Implement this method to perform extra treatments before and
	 * after the invocation. Polite implementations would certainly
	 * like to invoke {@link Joinpoint#proceed()}.
	 * @param invocation the method invocation joinpoint
	 * @return the result of the call to {@link Joinpoint#proceed()};
	 * might be intercepted by the interceptor
	 * @throws Throwable if the interceptors or the target object
	 * throws an exception
	 */

	@Override
	public Object invoke(MethodInvocation inv) throws Throwable {
		System.out.println("method name "+inv.getMethod()+" arguments "+inv.getArguments().length+" ");
		Object ret = null;
		try {
			ret = inv.proceed();
		} catch (Throwable ex) {
			Method handlerMethod = getExceptionHandler(ex);
			if (handlerMethod != null) {
				invokeHandlerMethod(inv, ex, handlerMethod);
			}
			throw ex;
		}
		System.out.println("method name "+inv.getMethod()+" returning "+ret);
		return ret;
	}


	private void invokeHandlerMethod(MethodInvocation inv, Throwable ex, Method method)  throws Throwable{
		Object[] handlerArgs;
		if (method.getParameterCount() == 1) {
			handlerArgs = new Object[] { ex };
		}
		else {
			handlerArgs = new Object[] {inv.getMethod(), inv.getArguments(), inv.getThis(), ex};
		}
		try {
			method.invoke(this.throwsAdvice, handlerArgs);
		}
		catch (InvocationTargetException targetEx) {
			throw targetEx.getTargetException();
		}
		
	}


	private Method getExceptionHandler(Throwable exception) {
		Class<?> exceptionClass = exception.getClass();
		
		Method handler = this.exceptionHandlerMap.get(exceptionClass);
		while (handler == null && exceptionClass != Throwable.class) {
			exceptionClass = exceptionClass.getSuperclass();
			handler = this.exceptionHandlerMap.get(exceptionClass);
		}
		
		return handler;
	}
	

}
