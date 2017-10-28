package com.ibm.model;

import org.springframework.aop.framework.AopContext;

public class CustomerImpl implements Customer {

	@Override
	public void foo(int n) {
		// TODO Auto-generated method stub
		System.out.println("foo "+n);
		//this.abc();
		((Customer)AopContext.currentProxy()).abc();
	}

	@Override
	public void bar() {
		System.out.println("bar");
	}

	@Override
	public void abc() {
		// TODO Auto-generated method stub
		System.out.println("abc");
	}

}
