package ru.dego.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dego.springBoot.dao.UserDAO;
import ru.dego.springBoot.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public void update(Long id, User user) {
        userDao.update(id, user);
    }

    public void remove(Long id) {
        userDao.remove(id);
    }

    public User getById(Long id) {
        return userDao.getById(id);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
