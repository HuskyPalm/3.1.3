package ru.kata.spring.boot_security.demo.dao;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    EntityManager manager;

    @Override
    public void add(Role role) {
        manager.persist(role);
    }
}
