package com.avsoft.hospital.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.avsoft.hospital.Exception.PatientServiceException;
import com.avsoft.hospital.entiry.Patient;
import com.avsoft.hospital.repository.PatientRepository;
import com.avsoft.hospital.request.PatientRequest;
import com.avsoft.hospital.response.PatientResponseBody;
import com.avsoft.hospital.service.PatientService;

@Service
@EnableTransactionManagement
public class PatientServiceImpl implements PatientService{
	


	@Autowired
	PatientRepository patientRepository;

	public void savePatient(PatientRequest pr) {
		Patient p = cretePatient(pr);
		patientRepository.save(p);
	}

	private Patient cretePatient(PatientRequest pr) {
		Patient p = new Patient();
		p.setAddress(pr.getAdd());
		p.setEmail(pr.getEmail());
		p.setName(pr.getName());
		return p;
	}

	@Override
	public PatientResponseBody getPatientRequestBody(int pid) {


		Optional<Patient> optional = patientRepository.findById(pid);
		
		if (optional.isEmpty()) {
			throw new PatientServiceException("Invlaid patient Id");
		}
		
			Patient p = optional.get();
			PatientResponseBody prb = new PatientResponseBody();
			prb.setAddress(p.getAddress());
			prb.setName(p.getName());
			return prb;
	}

	
	
	
	

	
	
	public void validatePid(Integer pid) {
		
		{if (pid.toString().length() != 5) {
			
			throw new PatientServiceException("Invalid Patient Exception");
			
		}}
		
		
	}

	@Override
	public List<Patient> getAllPatients() {

	
		return patientRepository.findAll();
	}

	@Override
	public PatientResponseBody getPatientRequestBody(String name, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getAllPatientsByNameAndEmail(String name,String email) {
		
		return patientRepository.findByNameAndEmail(name, email);
	}
	
	@Override
	public List<Patient> getAllPatientsByName(String name) {
		
		return patientRepository.getPatientByName(name);
	}
	
	@Override
	public List<Patient> getAllPatientsByEmail(String email) {
		
		return patientRepository.getPatientByEmail(email);
	}
	
	
	
	
	
}





