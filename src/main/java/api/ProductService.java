package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;

    int getProductCount() throws IOException;

    Product getProductByName(String productName) throws IOException;

    boolean isProductAvailable(String productName) throws IOException;

    boolean isProductExist(String productName) throws IOException;

    boolean isProductExist(Long id) throws IOException;

}
