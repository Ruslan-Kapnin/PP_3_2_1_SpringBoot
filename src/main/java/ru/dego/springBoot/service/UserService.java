package ru.dego.springBoot.service;

import ru.dego.springBoot.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void update(Long id, User user);

    void remove(Long id);

    User getById(Long id);

    List<User> getUsers();
}
