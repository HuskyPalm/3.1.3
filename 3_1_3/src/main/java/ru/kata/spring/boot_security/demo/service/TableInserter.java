package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class TableInserter implements CommandLineRunner {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private Set<Role> temp;


    @Autowired
    public TableInserter(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("user",
                passwordEncoder.encode("user"), 77);
        User user2 = new User("admin",
                passwordEncoder.encode("admin"), 15);
        User user3 = new User("Step",
                passwordEncoder.encode("100"), 82);
        Role user = new Role("ROLE_USER");
        Role admin = new Role("ROLE_ADMIN");
        roleRepository.save(user);
        roleRepository.save(admin);

        user1.addRole(user);
        user2.addRole(admin);
        user3.addRole(user);
        user3.addRole(admin);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
