package com.jpahibernate.onetoonemapping.entity;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="person")
public class Person {

	@Id
	@Column(name="id")
	@SequenceGenerator(name= "person_id_seq", sequenceName="person_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")

	private BigInteger id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	private String dob;
	
	private String gender;
	
	@OneToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="address_id")
	private Address address;
	
}
