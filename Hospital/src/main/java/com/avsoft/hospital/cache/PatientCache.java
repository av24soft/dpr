package com.avsoft.hospital.cache;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
@Component
public class PatientCache {

	
	HashMap m  =new HashMap();
	
	
	@PostConstruct
	public void fetchTheDataForCache()
	{		//repository.findAllPatient();
		System.out.println("this is postconstruct");
	}
	
	@PreDestroy
	public void beanDestroyMehotd()
	{
		System.out.println("this is destroyed");
	}
	
	
	
	
	

	public Object getCachePatient(String id)
	{
		return m.get(id);
		
	}
	
	public void addPetientt()
	{
		
		
	}
	public void clearCache()
	{
		
		m.clear();
	}
	
	
	
	
	
	
}
