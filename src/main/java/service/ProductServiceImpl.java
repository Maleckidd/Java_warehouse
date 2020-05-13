package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl(){
        this.products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products){
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public int getProductCount() {
        return products.size();
    }

    @Override
    public Product getProductByName(String productName) {

        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductAvailable(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName) && product.getProductCount() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
