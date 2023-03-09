package ru.kata.spring.boot_security.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;

@Component
public class RoleConverter implements Converter<String, Role> {
    @Override
    public Role convert(String id) {
        return Role.getAllRoles().get(Integer.parseInt(id));
    }
}
