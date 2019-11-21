package com.efficaxbs.myreports.core.service.impl;

import com.efficaxbs.myreports.core.domain.Person;
import com.efficaxbs.myreports.core.domain.User;
import com.efficaxbs.myreports.core.repository.PersonRepository;
import com.efficaxbs.myreports.core.repository.UserRepository;
import com.efficaxbs.myreports.core.service.PersonService;
import com.efficaxbs.myreports.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
	UserRepository userRepository;

    public User getDetailsById(Long id) {
        Iterable<User> datas = userRepository.findByUserId(id);
        Person dto = null;
        return datas.iterator().next();
    }

    public List<User> delete(Long id) {
        userRepository.deleteById(id);
        return null;
    }

	@Override
	public List<User> findAllUsers() {
		return null;
	}

	@Override
	public Person updateUser(Long id, User user) {
		return null;
	}

	public boolean addUser(User user) {
        user.setCreateddate(new Date());
        user.setUpdateddate(new Date());
        userRepository.save(user);
        return true;

    }


    public List<User> findAllPersons() {
        List<User> person = new ArrayList<>();
        userRepository.findAll().forEach(person::add);
        return person;

    }

    public User updatePerson(Long id, User person) {
        User person1 = userRepository.save(person);
        return person1;

    }


}
