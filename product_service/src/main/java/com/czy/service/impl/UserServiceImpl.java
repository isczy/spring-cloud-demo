package com.czy.service.impl;

import com.czy.dao.UserDao;
import com.czy.entity.User;
import com.czy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
       userDao.deleteById(id);
    }
}

