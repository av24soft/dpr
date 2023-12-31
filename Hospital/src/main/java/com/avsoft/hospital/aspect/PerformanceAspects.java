package com.avsoft.hospital.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.avsoft.hospital.Exception.PatientServiceException;


public class PerformanceAspects {

	@Around("execution(* com.avsoft.hospital.controller.PatientController.*(..))")
	public Object checkPerformance(ProceedingJoinPoint pj) throws Throwable {

		
		Object o;
		try {
		o =pj.proceed();
		} catch (PatientServiceException pe) {
			return new ResponseEntity(pe.getErrorMessage(), HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(o,HttpStatus.OK);
	}
	@AfterThrowing("execution(* com.avsoft.hospital.controller.PatientController.*(..))")
	public void exceptionHandling(Throwable  e) throws Throwable {

	
		System.out.println("this is rollback");
	
	}
	
}
