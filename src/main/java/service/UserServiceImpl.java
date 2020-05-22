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

    @Override
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) throws IOException, UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException {
        if (userValidator.isValidate(user)) {
            userDao.saveUser(user);
        }
    }

    @Override
    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }
}

