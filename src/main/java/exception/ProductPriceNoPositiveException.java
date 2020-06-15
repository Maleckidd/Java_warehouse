package exception;

public class ProductPriceNoPositiveException extends Exception {
    public ProductPriceNoPositiveException(){super();}
    public ProductPriceNoPositiveException(String message){super(message);}
}
