package service;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void getAllProductsTest() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Skirt", 99f, 100f, "white", 1));
        products.add(new Cloth(2L, "Skirt", 99f, 100f, "blue", 2, "M", "cotton"));
        products.add(new Boots(2L, "Skirt", 99f, 100f, "blue", 2, 42, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productService.getAllProducts();

        Assert.assertEquals(products, productsFromTestClass);

    }

    @Test
    public void getProductCountTest() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Skirt", 99f, 100f, "white", 1));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        Assert.assertEquals(1, productService.getProductCount());
    }

    @Test
    public void getProductByNameTest() {

        List<Product> products = new ArrayList<Product>();
        Product skirt = new Product(1L, "Skirt", 99f, 100f, "white", 1);
        Product tshirt = new Product(2L, "T-shirt", 99f, 100f, "blue", 2);
        products.add(skirt);
        products.add(tshirt);

        ProductServiceImpl productService = new ProductServiceImpl(products);

        Assert.assertEquals(tshirt, productService.getProductByName("T-shirt"));

    }

    @Test
    public void getProductByNameNullTest() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Skirt", 99f, 100f, "white", 1));
        products.add(new Product(2L, "T-shirt", 99f, 100f, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        Assert.assertNull(productService.getProductByName("Boots"));

    }

    @Test
    public void isProductAvailableTest() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(2L, "T-shirt", 99f, 100f, "blue", 0));
        products.add(new Product(1L, "Skirt", 99f, 100f, "white", 1));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        Assert.assertTrue(productService.isProductAvailable("Skirt"));
    }

    @Test
    public void isProductAvailableFalseTest() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Skirt", 99f, 100f, "white", 1));
        products.add(new Product(2L, "T-shirt", 99f, 100f, "blue", 0));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        Assert.assertFalse(productService.isProductAvailable("T-shirt"));
    }

    @Test
    public void isProductNameExistTest() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Skirt", 99f, 100f, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        Assert.assertTrue(productService.isProductExist("Skirt"));
    }

    @Test
    public void isProductNameExistFalseTest() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "T-shirt", 99f, 100f, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        Assert.assertFalse(productService.isProductExist("Skirt"));
    }

    @Test
    public void isProductIdExistTest() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Skirt", 99f, 100f, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        Assert.assertTrue(productService.isProductExist(1L));
    }

    @Test
    public void isProductIdExistFalseTest() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "T-shirt", 99f, 100f, "blue", 2));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        Assert.assertFalse(productService.isProductExist(2L));
    }


}
