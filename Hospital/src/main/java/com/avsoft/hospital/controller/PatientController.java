package com.avsoft.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avsoft.hospital.Exception.PatientServiceException;
import com.avsoft.hospital.entiry.Patient;
import com.avsoft.hospital.request.PatientRequest;
import com.avsoft.hospital.response.PatientResponseBody;
import com.avsoft.hospital.service.PatientService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/patient")
public class PatientController {

	PatientService patientService;
	
	@Autowired
	PatientController(PatientService patientService)
	{this.patientService = patientService;}
	

	@PostMapping
	public void addPatient(@RequestBody PatientRequest pr) {
		patientService.savePatient(pr);

	}

	@GetMapping("/get")
	public ResponseEntity<Object> getAllPatient() {

		patientService.getAllPatients();

		return new ResponseEntity<Object>(patientService.getAllPatients(), HttpStatus.OK);

	}

	@GetMapping("/{pid}")
	public ResponseEntity getPatient(@PathVariable Integer pid) throws Exception {
		PatientResponseBody p;

		try {
			patientService.validatePid(pid);
			p = patientService.getPatientRequestBody(pid);
		} catch (PatientServiceException pe) {
			return new ResponseEntity(pe.getMessage(), HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(p, HttpStatus.OK);
	}

	@GetMapping("/get/{name}/{email}")
	public ResponseEntity getPatientByNameAndEmail(@PathVariable("name") String name,
			@PathVariable("email") String email) {
		return new ResponseEntity(patientService.getAllPatientsByNameAndEmail(name, email), HttpStatus.OK);

	}

	@GetMapping("/get/{name}")
	public ResponseEntity getPatientByName(@PathVariable("name") String name) {
		return new ResponseEntity(patientService.getAllPatientsByName(name), HttpStatus.OK);

	}
	
	@GetMapping("/getByEmail/{email}")
	public ResponseEntity getPatientByEmail(@PathVariable("email") String email) {
		return new ResponseEntity(patientService.getAllPatientsByEmail(email), HttpStatus.OK);

	}
}