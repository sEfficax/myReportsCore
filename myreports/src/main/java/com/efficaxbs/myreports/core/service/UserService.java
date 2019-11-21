package com.efficaxbs.myreports.core.service;

import com.efficaxbs.myreports.core.domain.Person;
import com.efficaxbs.myreports.core.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    public User getDetailsById(Long id);

    public boolean addUser(User user);

    public List<User> delete(Long id);

    public List<User> findAllUsers();

    public Person updateUser(Long id, User user);

}     
