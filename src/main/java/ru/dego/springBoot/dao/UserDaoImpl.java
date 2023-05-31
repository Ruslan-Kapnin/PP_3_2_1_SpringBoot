package ru.dego.springBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.dego.springBoot.model.User;

import java.util.List;


@Component
public class UserDaoImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void update(Long id, User user) {
        User userToUpdate = getById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setAge(user.getAge());
        entityManager.merge(userToUpdate);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    public void init() {
        save(new User("Walter", "White", 52));
        save(new User("Jesse", "Pinkman", 25));
        save(new User("Saul", "Goodman", 32));
        save(new User("Mike", "Ehrmantraut", 69));
    }
}
