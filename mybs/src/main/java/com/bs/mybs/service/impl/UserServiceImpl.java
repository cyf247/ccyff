package com.bs.mybs.service.impl;

import com.bs.mybs.dao.UserDao;
import com.bs.mybs.model.User;
import com.bs.mybs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao dao;
    @Override
    @Transactional
    public List<User> findAll() {
        return dao.findAll();
    }
}
