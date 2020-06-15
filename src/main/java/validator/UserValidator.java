package validator;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import service.UserServiceImpl;

import java.io.IOException;

public class UserValidator {

    private final int MIN_LENGTH_PASSWORD = 6;
    private final int MIN_LENGTH_LOGIN = 4;

    private static UserValidator instance = null;

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }

        return instance;
    }

    private UserValidator() {
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException {
        if (isPasswordEnoughLong(user.getPassword()))
            throw new UserShortLengthPasswordException("Password is too short");

        if (isLoginEnoughLong(user.getLogin()))
            throw new UserShortLengthLoginException("Login is too short");

        return true;
    }

    public boolean isPasswordEnoughLong(String password) {
        return password.length() < MIN_LENGTH_PASSWORD;
    }

    public boolean isLoginEnoughLong(String login) {
        return login.length() < MIN_LENGTH_LOGIN;
    }
}