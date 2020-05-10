package api;

import entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    int getProductCount();

    Product getProductByName(String productName);

    boolean isProductAvailable(String productName);

    boolean isProductNameExist(String productName);

    boolean isProductIdExist(Long id);


}
