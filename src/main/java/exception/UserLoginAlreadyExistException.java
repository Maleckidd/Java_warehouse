package exception;

public class UserLoginAlreadyExistException extends Exception{
    public UserLoginAlreadyExistException(){super();}
    public UserLoginAlreadyExistException(String message){super(message);}
}
