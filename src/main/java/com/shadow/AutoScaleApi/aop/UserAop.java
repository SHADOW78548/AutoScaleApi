package com.shadow.AutoScaleApi.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAop {
	private static final Logger logger = LoggerFactory.getLogger(UserAop.class);
	
	@Pointcut("execution(* com.shadow.AutoScaleApi.controller.UserController.*(..))")
	public void userControllerMethods() {}
	
	@Pointcut("execution(* com.shadow.AutoScaleApi.service.UserService.*(..))")
	public void userServiceMethods() {}
	
	@Before("userControllerMethods() || userServiceMethods()")
	public void logMethodEntry(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		logger.info("Entering method: " + methodName + " with arguments: " + Arrays.toString(args));
	}
	
	@AfterReturning(pointcut = "userControllerMethods() || userServiceMethods()", returning = "result")
	public void logMethodExit(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		logger.info("Exiting method: " + methodName + " with result: " + result);
	}
	
	@AfterThrowing(pointcut = "userControllerMethods() || userServiceMethods()", throwing = "error")
	public void logMethodException(JoinPoint joinPoint, Exception error) {
		String methodName = joinPoint.getSignature().getName();
		logger.error("Exception in method: " + methodName + " with message: " + error.getMessage());
	}
	
	
	
}
