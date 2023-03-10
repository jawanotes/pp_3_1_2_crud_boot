package com.hkl.pp_3_1_2_crud_boot.dao;


import com.hkl.pp_3_1_2_crud_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    //public UserDaoImpl() {

    //}

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user); // cannot flush() here...
    }
    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUser(User user) {
        return getUser(user.getId());
    }

/*    @Override
    public void deleteUser(long id) {

    }*/
    @Override
    public void deleteUser(User user) {
        entityManager.remove(getUser(user));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<?> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}
