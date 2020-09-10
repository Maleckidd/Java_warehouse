package service;

import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import validator.ProductValidator;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl instance = null;
    private ProductDaoImpl productDao = ProductDaoImpl.getInstance("product.data");
    private ProductValidator productValidator = ProductValidator.getInstance();

    public ProductServiceImpl() {
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    @Override
    public int getProductCount() throws IOException {
        return getAllProducts().size();
    }

    @Override
    public Product getProductByName(String productName) throws IOException {
        for (Product product : getAllProducts()) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductOnStock(String productName) {
        try {
            for (Product product : getAllProducts()) {
                if (isProductExist(productName) && product.getProductCount() > 0)
                    return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        Product product = null;
        try {
            product = getProductByName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (product == null) return false;
        return true;
    }

    @Override
    public boolean isProductExist(Long id) {
        Product product = null;
        try {
            product = getAllProducts().get(id.intValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (product == null) return false;
        return true;
    }

    @Override
    public boolean saveProduct(Product product) {
        try {
            if (productValidator.isValidate(product)) {
                productDao.saveProduct(product);
                System.out.println("Product added successful");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
