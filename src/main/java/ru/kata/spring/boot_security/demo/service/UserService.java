package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Person;

import java.util.List;

@Service
public interface UserService {
    void add(Person person);

    void update(long id, Person updatedPerson);

    void delete(long id);

    List<Person> getAll();

    Person getUserById(long id);
    Person getPersonByUsername(String username);
    User findByUsername(String username);
}
