package com.usercorp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.usercorp.models.User;

@Dependent
@Transactional
public class UsersDao {

    @Inject
    EntityManager em;

    @Inject
    Logger LOG;

    public List<User> getAllUsers() {
        try {
            List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
            LOG.info("[RETRIVING USERS]");
            return users;
        } catch (Exception ex) {
            LOG.severe("[EXCEPTION OCURRED]");
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public User getUserById(int id) {
        try {
            User user = em.find(User.class, id);
            LOG.info(String.format("[USER FETECHED][ %s ]", user));
            em.detach(user);
            em.flush();
            return user;
        } catch (Exception ex) {
            LOG.severe("[EXCEPTION OCURRED]");
            ex.printStackTrace();
            return null;
        }
    }

    public void createUser(User user) {
        try {
            em.persist(user);
            LOG.info(String.format("[USER CREATED][ %s ]", user));
        } catch (Exception ex) {
            LOG.severe("[EXCEPTION OCURRED]");
            ex.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            User user = em.find(User.class, id);
            LOG.info(String.format("[USER TO REMOVE][ %s ]", user));
            System.out.println(user.getName());
            em.remove(user);
            em.flush();
            LOG.info(String.format("[USER DELETED]"));
        } catch (Exception ex) {
            LOG.severe("[EXCEPTION OCURRED]");
            ex.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            User userDB = em.find(User.class, user.getId());
            LOG.info(String.format("[USER TO UPDATE][ %s ]", user));
            userDB.setName(user.getName());
            userDB.setLastName(user.getLastName());
            userDB.setEmail(user.getEmail());
            em.persist(userDB);
            em.flush();
            LOG.info(String.format("[USER UPDATED][ %s ]", userDB));
        } catch (Exception ex) {
            LOG.severe("[EXCEPTION OCURRED]");
            ex.printStackTrace();
        }
    }

}
