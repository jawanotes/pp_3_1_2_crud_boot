package com.hkl.pp_3_1_2_crud_boot.service;



import com.hkl.pp_3_1_2_crud_boot.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public User getUser(User user);
    public User getUser(Long id);
    //public void deleteUser(long id);
    public void deleteUser(User user);
    public void updateUser(User user);
    public List<?> getAllUsers();
}
