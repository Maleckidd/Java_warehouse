package validator;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import service.ProductServiceImpl;
import sun.jvm.hotspot.types.JBooleanField;

public class ProductValidator {

    private static ProductValidator instance = null;

    public static ProductValidator getInstance(){
        if(instance == null){
            instance = new ProductValidator();
        }
        return instance;
    }

    public boolean isValidate(Product product) throws ProductPriceNoPositiveException, ProductCountNegativeException, ProductWeightNoPositiveException, ProductNameEmptyException {
        if(isPriceBiggerThenZero(product))
            throw new ProductPriceNoPositiveException("Price is not positive");

        if(isCountPositive(product))
            throw new ProductCountNegativeException("Count is not positive");

        if(isWeightBiggerThenZero(product))
            throw new ProductWeightNoPositiveException("Weight is not positive");

        if (isNameEmpty(product))
            throw new ProductNameEmptyException("Product name cannot be empty.");

            return true;
    }

        private boolean isPriceBiggerThenZero(Product product){ return product.getPrice() < 0; }
        private boolean isCountPositive(Product product){ return product.getProductCount() < 0; }
        private boolean isWeightBiggerThenZero(Product product){ return product.getWeight() < 0; }
        private boolean isNameEmpty(Product product){ return product.getProductName().isEmpty(); }



}
