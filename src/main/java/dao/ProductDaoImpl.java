package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private final String fileName;
    private final String productType;

    public ProductDaoImpl(String fileName, String productType) {
        this.fileName = fileName;
        this.productType = productType;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName, false);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    @Override
    public void saveProducts(List<Product> products) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        for (Product product : products) {
            printWriter.println(product.toString());
        }

        printWriter.close();
    }

    @Override
    public void removeProductById(String productId) throws IOException {
        List<Product> products = getAllProducts();

        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getId().equals(productId)){
                products.remove(i);
            }
        }

        saveProducts(products);
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for(int i=0; i < products.size(); i++){
            if(products.get(i).getProductName().equals(productName)){
                products.remove(i);
            }
        }

        saveProducts(products);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String readOneLineFromFile = bufferedReader.readLine();


        while (readOneLineFromFile != null){
           Product product = ProductParser.stringToProduct(readOneLineFromFile, productType);
           if (product != null)
           {
                products.add(product);
            }
        }
        bufferedReader.close();
        return products;
    }

    @Override
    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();

        for(Product product: products){
            if (product.getId().equals(productId)){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for(Product product: products){
            if (product.getProductName().equals(productName)){
                return product;
            }
        }
        return null;
    }
}
