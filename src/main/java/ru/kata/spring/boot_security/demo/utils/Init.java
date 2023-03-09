package ru.kata.spring.boot_security.demo.utils;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Person;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@Component
public class Init {
    private final UserService userService;
    private final RoleService roleService;

    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void init() {
        try {
            Role.getAllRoles().forEach(roleService::add);
            // создание базового админа
            HashSet<Role> roles = new HashSet<>();
            roles.add(new Role(0, "ROLE_ADMIN"));
            roles.add(new Role(1, "ROLE_USER"));
            userService.add(
                    new Person("Администратор", "Администраторов", 100,
                            roles,
                            "admin",
                            "admin")
            );
        } catch (Exception exception) {/*ignore*/}
    }

}
