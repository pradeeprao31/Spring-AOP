package com.AOP.MyAspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect

public class MyAspect {
	
	
	@Before("execution(* com.AOP.Service.PaymentServiceImpl.makePayment())")
	public void beforPayment() {
		
		System.out.println("Payment Start.......");
	}
	
	
	@After("execution(* com.AOP.Service.PaymentServiceImpl.makePayment())")
	public void afterPayment() {
		
		System.out.println("Payment Done Success Fully.......");
	}
	

}
