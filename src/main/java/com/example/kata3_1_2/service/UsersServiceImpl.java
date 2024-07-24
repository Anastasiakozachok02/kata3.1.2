package com.example.kata3_1_2.service;

import com.example.kata3_1_2.dao.UserDao;
import com.example.kata3_1_2.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    private UserDao userDao;

    public UsersServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void change(User user) {
        userDao.save(user);
    }
}
