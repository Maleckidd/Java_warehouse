package validator;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import service.ProductServiceImpl;

public class ProductValidator {

    private static ProductValidator instance = null;

    public static ProductValidator getInstance(){
        if(instance == null){
            instance = new ProductValidator();
        }
        return instance;
    }

    public boolean isValidate(Product product) throws ProductPriceNoPositiveException, ProductCountNegativeException, ProductWeightNoPositiveException {
        if(isPriceBiggerThenZero(product))
            throw new ProductPriceNoPositiveException("Price is not positive");

        if(isCountPositive(product))
            throw new ProductCountNegativeException("Count is not positive");

        if(isWeightBiggerThenZero(product))
            throw new ProductWeightNoPositiveException("Weight is not positive");

        return true;
    }

    public boolean isPriceBiggerThenZero(Product product){
        return product.getPrice() < 0;
    }

    public boolean isCountPositive(Product product){ return product.getProductCount() < 0; }
    public boolean isWeightBiggerThenZero(Product product){ return product.getWeight() < 0; }




}
