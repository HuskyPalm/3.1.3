package ru.kata.spring.boot_security.demo.dao;

import org.springframework.security.core.userdetails.User;
import ru.kata.spring.boot_security.demo.model.Person;

import java.util.List;

public interface UserDao {


    void add(Person person);

    void update(long id, Person updatedPerson);

    void delete(long id);

    List<Person> getAll();

    Person getUserById(long id);

    Person getPersonByUsername(String username);

    User findByUsername(String username);
}