package ru.dego.springBoot.dao;


import ru.dego.springBoot.model.User;

import java.util.List;

public interface UserDAO {

    void save(User user);

    void update(Long id, User user);

    void remove(Long id);

    User getById(Long id);

    List<User> getUsers();

    void init();
}
