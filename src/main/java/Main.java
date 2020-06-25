import entity.User;
import entity.parser.ProductParser;
import entity.parser.UserParser;
import facade.UserRegisterLoginFacadeImpl;
import service.ProductServiceImpl;
import service.UserServiceImpl;

import java.util.Scanner;

public class Main {

    public static void loggedMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Add new product");
        System.out.println("0 - Log out");
    }

    public static void productTypeMenu() {
        System.out.println("1 - Add boots");
        System.out.println("2 - Add cloths");
        System.out.println("3 - Others");
        System.out.println("0 - Exit program");

    }

    public static void main(String[] args) {

        UserRegisterLoginFacadeImpl userRegisterLogin = UserRegisterLoginFacadeImpl.getInstance();
        ProductServiceImpl productService = ProductServiceImpl.getInstance();
        Scanner scan = new Scanner(System.in);
        UserServiceImpl userService = new UserServiceImpl();

        try {
            System.out.println(userService.getAllUsers());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        int x;

        System.out.println();
        do {
            System.out.println("MANAGEMENT MENU");
            System.out.println("1 - Log in");
            System.out.println("2 - Sign in");
            System.out.println("0 - Exit");
            x = scan.nextInt();

            switch (x) {
                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Log in!");
                    System.out.println("Enter login");
                    String login = scan.next();
                    System.out.println("Enter password");
                    String password = scan.next();
                    if (userRegisterLogin.loginUser(login, password)) {
                        System.out.println("Logged in");
                        do {
                            loggedMenu();
                            x = scan.nextInt();
                            switch (x) {
                                case 1:
                                    productTypeMenu();
                                    x = scan.nextInt();
                                    switch (x) {
                                        case 0:
                                            System.out.println("Exiting program...");
                                            System.exit(0);
                                            break;
                                        case 1:
                                            System.out.println("Enter boots details id#productName#price#weight#color#productCount#size#isNaturalSkin");
                                            String boots = scan.next();
                                            productService.saveProduct(ProductParser.stringToProduct("B#" + boots));
                                            break;
                                        case 2:
                                            System.out.println("Enter cloth details id#productName#price#weight#color#productCount#size#material");
                                            String cloth = scan.next();
                                            productService.saveProduct(ProductParser.stringToProduct("C#" + cloth));
                                            break;
                                        case 3:
                                            System.out.println("Enter product details id#productName#price#weight#color#productCount");
                                            String product = scan.next();
                                            productService.saveProduct(ProductParser.stringToProduct("P#" + product));
                                            break;
                                        default:
                                            System.out.println("Entered value incorrect exiting program...");
                                            System.exit(0);
                                    }
                                    break;
                                case 0:
                                    System.out.println("Exiting program...");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Entered value incorrect exiting program...");
                                    System.exit(0);
                            }
                        } while (true);
                    }
                    System.out.println("Login error");
                    break;
                case 2:
                    System.out.println("Sign in!");
                    System.out.println("Enter id");
                    String id = scan.next();
                    System.out.println("Enter login");
                    String regLogin = scan.next();
                    System.out.println("Enter password");
                    String regPassword = scan.next();
                    String user = id + User.USER_SEPARATOR + regLogin + User.USER_SEPARATOR + regPassword;
                    User parsedUser = UserParser.stringToUser(user);
                    System.out.println(parsedUser);
                    if (userRegisterLogin.registerUser(parsedUser)){
                    System.out.println("Registration successful");}
                    break;
                default:
                    System.out.println("Entered value incorrect exiting program...");
                    System.exit(0);
            }

        }
        while (true);
    }
}
