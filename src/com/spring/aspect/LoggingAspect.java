package com.spring.aspect;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.spring.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.spring.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("execution(* com.spring.services.*.*(..))")
	private void forServicespackage() {}

	@Pointcut("forControllerPackage() || forDAOPackage() || forServicespackage()")
	private void forAppFlow() {}
	
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info(" \n\n ============>in @Before calling method "+method);
		
//		System.out.println(" \n\n ============>in @Before calling method "+method);
		
		Object [] args = theJoinPoint.getArgs();
		
		for(Object o:args) {
			myLogger.info("======> argument "+o);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void afterReturning(JoinPoint theJoinPoint,Object result) {
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info(" \n\n ============>in @Before calling method "+method);
		
		myLogger.info("\n========> returning "+result);
	}
}
