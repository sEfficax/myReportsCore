package com.efficaxbs.myreports.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.efficaxbs.myreports.core.domain.Person;

@Component
public interface PersonService {

	public Person getDetailsByNPI(String num);

	public List<Person> findAll();

	public Optional<Person> findById(Long id);

	public Person save(Person person);

	public Person deleteById(Long id);

}
