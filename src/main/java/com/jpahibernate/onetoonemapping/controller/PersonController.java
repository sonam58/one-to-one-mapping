package com.jpahibernate.onetoonemapping.controller;


import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpahibernate.onetoonemapping.dto.PersonDTO;
import com.jpahibernate.onetoonemapping.entity.Person;
import com.jpahibernate.onetoonemapping.service.PersonService;

@RestController
public class PersonController {
@Autowired
	PersonService personService;
	
	@PostMapping(path="/persons")
	public ResponseEntity<?> savePerson(@RequestBody PersonDTO personDTO){
		personService.savePerson(personDTO);
		return ResponseEntity.ok("Person added");
	}
	
	@GetMapping(path="/persons")
	public ResponseEntity<List<PersonDTO>> getPersons(){
		List<PersonDTO> personDTOs = personService.getPersonsList(); 
		return ResponseEntity.ok(personDTOs);
	}
	
	@GetMapping(path="/persons/{personId}")
	public ResponseEntity<?> getPerson(@PathVariable ("personId") BigInteger personId){
	PersonDTO personDto = personService.getPerson(personId);
		return ResponseEntity.ok(personDto);
	}
	
	@PutMapping(path="/persons/{personId}")
	public ResponseEntity<?> updatePerson(@PathVariable ("personId") BigInteger personId, @RequestBody PersonDTO personDTO ){
		personService.updatePerson(personId, personDTO);
		return ResponseEntity.ok("Entity updated successfully");
	}
	
	@DeleteMapping(path="/persons/{personId}")
	public ResponseEntity<?> deletePerson(@PathVariable("personId") BigInteger personId) throws Exception{
		
		personService.deletePerson(personId);
		return ResponseEntity.ok("Person deleted successfully");
	}
	
	
}
