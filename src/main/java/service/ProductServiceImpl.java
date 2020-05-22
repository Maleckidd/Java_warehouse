package service;

import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl instance = null;
    private  ProductDaoImpl productDao = new ProductDaoImpl("product.data", "PRODUCT");

    public ProductServiceImpl() {}

    public static ProductServiceImpl getInstance(){
        if(instance == null){
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
        return productDao.getProductByProductName(productName);
    }

    @Override
    public boolean isProductAvailable(String productName)  {
        try{
            for(Product product : getAllProducts()){
                if(isProductExist(productName) && product.getProductCount() > 0)
                    return true;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName)  {
        Product product = null;
        try{
            product = productDao.getProductByProductName(productName);
        } catch (IOException e){
            e.printStackTrace();
        }
        if (product == null) return false;
        return true;
    }

    @Override
    public boolean isProductExist(Long id) {
        Product product = null;
        try{
            product = productDao.getProductById(id);
        } catch (IOException e){
            e.printStackTrace();
        }
        if (product == null) return false;
        return true;
    }
}
