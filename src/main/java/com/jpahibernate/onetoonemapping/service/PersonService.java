package com.jpahibernate.onetoonemapping.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpahibernate.onetoonemapping.dto.PersonDTO;
import com.jpahibernate.onetoonemapping.entity.Person;
import com.jpahibernate.onetoonemapping.mapper.PersonMapper;
import com.jpahibernate.onetoonemapping.repository.PersonRepository;

@Service
public class PersonService {

	private final PersonMapper personMapper;
	private final PersonRepository personRepository;

	@Autowired
	public PersonService(PersonMapper personMapper, PersonRepository personRepository) {
		this.personMapper = personMapper;
		this.personRepository = personRepository;
	}

	public void savePerson(PersonDTO personDTO) {
		Person person = personMapper.dtoTOModel(personDTO);
		person = personRepository.save(person);
		System.out.println("person_id: " + person.getId());

	}

	public List<PersonDTO> getPersonsList() {
		return personMapper.modelToPersonList((List<Person>) personRepository.findAll());
	}

	public PersonDTO getPerson(BigInteger personId) {
		Optional<Person> personOptional = personRepository.findById(personId);
		Person person = personOptional.get();
		return personMapper.modelToDTO(person);
	}

	public void updatePerson(BigInteger personId, PersonDTO personDTO) {
		Optional<Person> optionalPerson = personRepository.findById(personId);
		if (optionalPerson.isPresent()) {
			personMapper.updatePerson(personDTO, optionalPerson.get());
			personRepository.save(optionalPerson.get());
		} else {
			System.out.println("Exception will be thrown");
		}

	}

	public void deletePerson(BigInteger personId) throws Exception {
		Person person = personRepository.findById(personId).orElseThrow(() -> new Exception("Person not found"));
		personRepository.delete(person);

	}

}
