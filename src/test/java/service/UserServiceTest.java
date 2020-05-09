package service;

import entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Test
    public void testGetAllUsers() {

        List<User> users = new ArrayList<User>();
        users.add(new User(1L, "admin", "admin"));
        users.add(new User(2L, "user1", "admin"));

        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> userFromTestClass = userService.getAllUsers();

        Assert.assertEquals(users, userFromTestClass);
    }

    @Test
    public void testAddUser() {

        List<User> users = new ArrayList<User>();
        User user = new User(1l, "admin", "admin");
        users.add(user);

        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        List<User> usersFromTestClass = userService.getAllUsers();

        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testRemoveUsers(){

        List<User> users = new ArrayList<User>();
        User admin = new User(1l, "admin", "admin");
        User user1 = new User(2l, "user", "admin");
        users.add(admin);
        users.add(user1);

        UserServiceImpl userService = new UserServiceImpl(users);
        userService.removeUserById(1l);
        users.remove(admin);
        List<User> userFromTestClass = userService.getAllUsers();

        Assert.assertEquals(users, userFromTestClass);


    }


}
