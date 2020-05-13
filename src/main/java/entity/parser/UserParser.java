package entity.parser;

import entity.User;

public class UserParser {

    public static User stringToUser(String stringToConv) {
        String[] userInformation = stringToConv.split(User.USER_SEPARATOR);

        Long id = Long.parseLong(userInformation[0]);
        String login = userInformation[1];
        String password = userInformation[2];

        return new User(id, login, password);
    }

}
