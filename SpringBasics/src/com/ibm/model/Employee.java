/**
 * 
 */
package com.ibm.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Ritam
 *
 */
public class Employee /*implements DisposableBean,InitializingBean,BeanNameAware,BeanFactoryAware,BeanPostProcessor*/{
	private Integer id;
	private String name;
	private List<String> emails;
	
	public Employee(){System.out.println("default constructor");}
	
	@Override
	public String toString(){
		return "id "+this.id+" name "+this.name;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("this is set name");
		this.name = name;
	}
	//@PostConstruct
	public void customInit(){
		System.out.println("this is custom init");
	}
	//@PreDestroy
	public void customDestroy(){
		System.out.println("this is custome destroy");
	}

	/*@Override
	public void destroy() throws Exception {

		System.out.println("this is custom destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("this is custom afterpropety");
		
	}

	@Override
	public void setBeanName(String arg0) {		
		System.out.println("this is set bean name");
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("this is set bean factory");
		
	}

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
        System.out.println("bean -post processors' after initialization");
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
        System.out.println("bean -post processors' before initialization"+arg1);
		return null;
	}

*/	/**
	 * @return the emails
	 */
	public List<String> getEmails() {
		return emails;
	}

	/**
	 * @param emails the emails to set
	 */
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	
	

}
