package com.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.AOP.Service.PaymentService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	
    	ApplicationContext applicationContext= new ClassPathXmlApplicationContext("com/AOP/config.xml"); 	
        PaymentService paymentService=	applicationContext.getBean("payment", PaymentService.class); 
       
        paymentService.makePayment();
    
    }
}
