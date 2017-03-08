package com.infotech.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class AccountServiceAspect {

	public Object aroundAdvice(ProceedingJoinPoint joinPoint){
		System.out.println("Before method:"+joinPoint.getSignature().getName()+",Class:"+joinPoint.getTarget().getClass().getSimpleName());
		
		long sTime = System.currentTimeMillis();
		Object object= null;
		try {
			object=joinPoint.proceed();
		} catch (Throwable ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("After method:"+joinPoint.getSignature().getName()+",Class:"+joinPoint.getTarget().getClass().getSimpleName());
		long eTime = System.currentTimeMillis();
		
		System.out.println("Total execution time taken by Method:"+joinPoint.getSignature().getName() +" is :"+(eTime-sTime)+" ms");
		return object;
	}
}
