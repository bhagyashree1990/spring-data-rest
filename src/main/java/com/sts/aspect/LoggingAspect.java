package com.sts.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	private final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut(
//			"execution(* com.sts.portal.repository.*.*(..))"
//			"target(com.sts.portal.repository.CityRepository)"	
			"this(com.sts.repository.BaseRepository)"
//			"bean(*Repository)"
			)
	public void inRepositoryLayer() {
		/**
		 * Pointcut that matches all repositories
		 */		
	}
	
	/**
	 * Advice that logs when a method is entered and exited
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("inRepositoryLayer()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		if(log.isDebugEnabled()) {
			log.debug("Enter: {}.{}() with argument(s): {}",
					joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(),
					Arrays.toString(joinPoint.getArgs()));
		}
		Object result = joinPoint.proceed();
		if(log.isDebugEnabled()) {
			log.debug("Exit: {}.{}() with argument(s): {}",
					joinPoint.getSignature().getDeclaringTypeName(),				
					joinPoint.getSignature().getName(),
					Arrays.toString(joinPoint.getArgs()));
		}
		return result;
	}
}
