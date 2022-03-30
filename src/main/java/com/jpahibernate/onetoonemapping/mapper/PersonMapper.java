package com.jpahibernate.onetoonemapping.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.jpahibernate.onetoonemapping.dto.PersonDTO;
import com.jpahibernate.onetoonemapping.entity.Person;

@Mapper(componentModel="spring")
public interface PersonMapper{
	
	Person dtoTOModel(PersonDTO personDTO);
	List<PersonDTO> modelToPersonList(List<Person> person);
	PersonDTO modelToDTO(Person person);
	void updatePerson( PersonDTO personDTO, @MappingTarget Person person);
	
}
