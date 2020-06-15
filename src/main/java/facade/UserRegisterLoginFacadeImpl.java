package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import service.UserServiceImpl;
import validator.UserValidator;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {

    private UserServiceImpl userService = UserServiceImpl.getInstance();
    private static UserRegisterLoginFacadeImpl instance = null;
    private UserValidator userValidator = UserValidator.getInstance();

    public static UserRegisterLoginFacadeImpl getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    @Override
    public boolean registerUser(User user) {
        try {
            if (userValidator.isValidate(user)) {
                return userService.addUser(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean loginUser(String login, String password) {
        if(userService.isCorrectLoginAndPassword(login, password)){
            return true;
        }
        return false;
    }
}
