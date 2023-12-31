package com.avsoft.hospital.service;

import java.util.List;

import com.avsoft.hospital.entiry.Patient;
import com.avsoft.hospital.request.PatientRequest;
import com.avsoft.hospital.response.PatientResponseBody;

public interface PatientService {

	public void savePatient(PatientRequest patientRequest);
	
	public PatientResponseBody getPatientRequestBody(int pid);
	public List<Patient> getAllPatients();
	public void validatePid(Integer pid) throws Exception;

	PatientResponseBody getPatientRequestBody(String name, String email);

	List<Patient> getAllPatientsByNameAndEmail(String name, String email);

	List<Patient> getAllPatientsByName(String name);

	List<Patient> getAllPatientsByEmail(String email);
	
	
	
}
