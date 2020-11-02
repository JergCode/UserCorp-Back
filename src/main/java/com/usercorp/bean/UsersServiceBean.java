package com.usercorp.bean;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.usercorp.dao.UsersDao;
import com.usercorp.models.User;

@ApplicationScoped
public class UsersServiceBean {

    @Inject
    UsersDao usersDao;

    @Inject
    Logger LOG;

    public List<User> getAllUsers() {
        LOG.info("[FETCHING ALL USERS]");
        return usersDao.getAllUsers();
    }

    public User getUser(int id) {
        LOG.info(String.format("[FETCHING USER] [ID: %d]", id));
        return usersDao.getUserById(id);
    }

    public void addUser(User user) {
        LOG.info(String.format("[CREATING USER] [Name: %s, Last Name: %s, Email: %s]", user.getName(),
                user.getLastName(), user.getEmail()));
        usersDao.createUser(user);
    }

    public void editUser(User user) {
        LOG.info(String.format("[EDITING USER] [Id: %d, Name: %s, Last Name: %s, Email: %s]", user.getId(),
                user.getName(), user.getLastName(), user.getEmail()));
        usersDao.updateUser(user);
    }

    public void deleteUser(int id) {
        LOG.info(String.format("[REMOVING USER] [ID: %d]", id));
        usersDao.deleteUser(id);
    }
}
