package com.avsoft.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avsoft.hospital.entiry.Patient;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Integer>{

	
	public List<Patient> findByNameAndEmail(String name, String email);
	
	
	@Query(value = "select * from patient where name = ?1",nativeQuery = true)
	public List<Patient> getPatientByName( String name);
	
	@Query(value = "Select p FROM Patient p where p.email =:email ")
	public List<Patient> getPatientByEmail(@Param("email") String email);
	
}
