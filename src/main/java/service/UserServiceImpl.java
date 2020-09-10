package service;

import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance = null;
    UserValidator userValidator = UserValidator.getInstance();
    UserDaoImpl userDao = UserDaoImpl.getInstance();

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public UserServiceImpl() {
    }

    public boolean isLoginExist(String login) {
        User user = getUserByLogin(login);
        return user != null;
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    @Override
    public boolean addUser(User user) {
        try {
            if (isLoginExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException();
            }
            if (userValidator.isValidate(user)) {
                userDao.saveUser(user);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }

    @Override
    public User getUserById(Long userId) {
        try {
            List<User> users = getAllUsers();
            for (User user : users) {
                if (user.getId().equals(userId)) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        try {
            List<User> users = getAllUsers();
            for (User user : users) {
                if (user.getLogin().equals(login)) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isCorrectLoginAndPassword(String login, String password) {
        User foundUser = getUserByLogin(login);
        if (foundUser == null) {
            return false;
        }
        boolean isCorrectLogin = foundUser.getLogin().equals(login);
        boolean isCorrectPassword = foundUser.getPassword().equals(password);

        return isCorrectLogin && isCorrectPassword;
    }

}

