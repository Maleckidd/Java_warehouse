package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;

    int getProductCount() throws IOException;

    Product getProductByName(String productName) throws IOException;

    boolean isProductOnStock(String productName);
    boolean isProductExist(String productName);
    boolean isProductExist(Long id);

    boolean saveProduct(Product product);
}
