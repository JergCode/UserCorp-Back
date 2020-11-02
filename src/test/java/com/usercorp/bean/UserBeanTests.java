package com.usercorp.bean;

import java.util.List;

import javax.inject.Inject;

import com.usercorp.models.User;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UserBeanTests {

    @Inject
    UsersServiceBean userBean;

    @Test
    public void addingUser() {
        User user = new User();
        user.setName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@mail.com");
        this.userBean.addUser(user);
    }

    @Test
    public void getUsers() {
        List<User> users = userBean.getAllUsers();
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(4);
        user.setName("Jessica");
        user.setLastName("Doe");
        user.setEmail("jessica.doe@mail.com");
        userBean.editUser(user);
    }

    @Test
    public void deleteUser() {
        int id = 4;
        userBean.deleteUser(id);
    }
}
