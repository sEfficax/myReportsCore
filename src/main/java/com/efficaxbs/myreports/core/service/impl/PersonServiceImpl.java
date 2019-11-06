package com.efficaxbs.myreports.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.efficaxbs.myreports.core.domain.Person;
import com.efficaxbs.myreports.core.repository.PersonRepository;
import com.efficaxbs.myreports.core.service.PersonService;

@Component
public class PersonServiceImpl implements PersonService{

	@Autowired(required = false)
	private PersonRepository personRepository;

	public Person getDetailsByNPI(String num) {

		Iterable<Person> datas = personRepository.findByNpi(num);
		Person dto = null;

		return datas.iterator().next();
	}

	public List<Person> findAll() {
		return (List<Person>) personRepository.findAll();
	}

	public Optional<Person> findById(Long id) {
		return personRepository.findById(id);

	}

	public Person save(Person person) {
		return personRepository.save(person);
	}

	public Person deleteById(Long id) {
		personRepository.deleteById(id);
		return null;
	}

}
