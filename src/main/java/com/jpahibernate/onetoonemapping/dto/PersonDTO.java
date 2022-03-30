package com.jpahibernate.onetoonemapping.dto;



import lombok.Data;

@Data
public class PersonDTO {

	private String firstName;
	
	private String lastName;
	
	private String dob;
	
	private String gender;
	
	private AddressDTO address;
}
