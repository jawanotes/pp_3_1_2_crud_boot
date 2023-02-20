package com.hkl.pp_3_1_2_crud_boot.service;


import com.hkl.pp_3_1_2_crud_boot.dao.UserDao;
import com.hkl.pp_3_1_2_crud_boot.model.User;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    /*    @Override
        public void deleteUser(long id) {
            userDao.deleteUser(id);
        }*/
    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<?> getAllUsers() {
        return userDao.getAllUsers();
    }
}
