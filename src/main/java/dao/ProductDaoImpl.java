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
    private static ProductDaoImpl instance = null;

    public static ProductDaoImpl getInstance(String fileName) {
        if (instance == null) {
            instance = new ProductDaoImpl(fileName);
        }
        return instance;
    }

    public ProductDaoImpl(String fileName) {
        this.fileName = fileName;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName, false);
        } catch (IOException e) {
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
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, false);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        for (Product product : products) {
            printWriter.println(product);
        }
        printWriter.close();
    }

    @Override
    public void removeProductById(String productId) throws IOException {
        List<Product> products = getAllProducts();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(productId)) {
                products.remove(i);
            }
        }

        saveProducts(products);
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equals(productName)) {
                products.remove(i);
            }
        }

        saveProducts(products);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String readOneLineFromFile = bufferedReader.readLine();


        while (readOneLineFromFile != null) {
            Product product = ProductParser.stringToProduct(readOneLineFromFile);
            products.add(product);
            readOneLineFromFile = bufferedReader.readLine();

        }
        bufferedReader.close();
        return products;
    }

}
