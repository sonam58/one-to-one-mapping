package com.jpahibernate.onetoonemapping.repository;

import java.math.BigInteger;
import java.util.List;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpahibernate.onetoonemapping.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, BigInteger> {

//	List<Person> findByOrderByDobAsc();
//	List<Person> findByfirstNameOrderByDob(String firstname, Sort sort);

}
