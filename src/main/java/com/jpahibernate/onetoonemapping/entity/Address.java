package com.jpahibernate.onetoonemapping.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="address")
public class Address {
	@Id
	@Column(name="id")
	@SequenceGenerator(name= "address_id_seq", sequenceName="address_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
	
	private BigInteger id;
	
	private String address1;
	
	private String address2;
	
	private String street;
	 
	private String city;
	
	private String state;
	
	private String zipcode;
	
	private String country;
	

	
}