package validator;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;

public class UserValidator {

    private final int MIN_LENGTH_PASSWORD  = 6;
    private final int MIN_LENGTH_LOGIN = 4;

    private static UserValidator instance = null;
    UserDao userDao = UserDaoImpl.getInstance();

    public static UserValidator getInstance() {
     if (instance == null) {
            instance = new UserValidator();
        }

        return instance;
    }

    private UserValidator() {
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException{
        if(isPasswordEnoughLong(user.getPassword()))
            throw new UserShortLengthPasswordException("Password is too short");

        if(isLoginEnoughLong(user.getLogin()))
            throw new UserShortLengthLoginException("Login is too short");

        if(isLoginExist(user.getLogin()))
            throw new UserLoginAlreadyExistException("Login is exist");

        return true;
    }

    public boolean isPasswordEnoughLong(String password){
        if(password.length()>= MIN_LENGTH_PASSWORD){
            return true;
        }
        return false;
    }

    public boolean isLoginEnoughLong(String login){
        if (login.length()>= MIN_LENGTH_PASSWORD){
            return true;
        }
        return false;
    }

    public boolean isLoginExist(String login) {
        User user = null;

        try {
            user = userDao.getUserByLogin(login);
        } catch (IOException e){
            e.printStackTrace();
        }
        if(user == null) return false;

        return true;
    }
}