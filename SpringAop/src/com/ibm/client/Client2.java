/**
 * 
 */
package com.ibm.client;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import com.ibm.aspect.CustomerAdvice;
import com.ibm.model.Customer;
import com.ibm.model.CustomerImpl;

/**
 * @author Ritam
 *
 */
public class Client2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer customer = new CustomerImpl();
		CustomerAdvice customerAdvice = new CustomerAdvice();
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(customerAdvice);
		advisor.setMappedNames(new String[]{"foo"});
		ProxyFactoryBean pfb = new ProxyFactoryBean();
		pfb.setTarget(customer);
		pfb.addAdvice(customerAdvice);
		pfb.addInterface(Customer.class);		
		//pfb.setInterceptorNames(new String[]{"advisor"});
		pfb.setExposeProxy(true);
		Customer customerProxy = (Customer)pfb.getObject();
		customerProxy.foo(20);
		

	}

}
