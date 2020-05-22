package dao;

import api.UserDao;
import entity.User;
import entity.parser.UserParser;
import utils.FileUtils;
import validator.UserValidator;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String fileName = "users.data";
    private static UserDaoImpl instance = null;

    private UserDaoImpl(){
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e){
            System.out.println("File path error");
            System.exit(-1);
        }
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }

        return instance;
    }

    @Override
    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    @Override
    public void saveUsers(List<User> users) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        for (User user : users) {
            printWriter.println(user.toString());
        }
        printWriter.close();
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<User> users = new ArrayList<>();

        String readOneLineFromFile = bufferedReader.readLine();

        while (readOneLineFromFile != null) {
            User user = UserParser.stringToUser(readOneLineFromFile);

            if (user != null) {
                users.add(user);
            }
        }

        bufferedReader.close();
        return users;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();

        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();

        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();

        for (User user : users) {
            if (user.getLogin().equals(login)) {
                users.remove(user.getId());
            }
        }

        saveUsers(users);
    }

    @Override
    public void removeUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();

        for (User user : users) {
            if (user.getId().equals(userId)) {
                users.remove(user.getId());
            }
        }
        saveUsers(users);
    }
}
