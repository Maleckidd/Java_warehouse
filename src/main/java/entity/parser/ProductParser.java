package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {

    public static Product stringToProduct(String productString, String productType) {
        if (productType.equals("PRODUCT")) {
            return convToProduct(productString);
        } else if (productType.equals("BOOTS")) {
            return convToBoots(productString);
        } else if (productType.equals("CLOTH")) {
            return convToCloth(productString);
        }
        return null;
    }

    public static Product convToProduct(String stringToConv) {
        String[] productInformation = stringToConv.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformation[0]);
        String productName = productInformation[1];
        Float price = Float.parseFloat(productInformation[2]);
        Float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        int productCount = Integer.parseInt(productInformation[5]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    public static Boots convToBoots(String stringToConv){
        String[] productInformation = stringToConv.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformation[0]);
        String productName = productInformation[1];
        Float price = Float.parseFloat(productInformation[2]);
        Float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        int productCount = Integer.parseInt(productInformation[5]);
        int size = Integer.parseInt(productInformation[6]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInformation[7]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    public static Cloth convToCloth(String stringToConv){
        String [] productInformations = stringToConv.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformations[0]);
        String productName = productInformations[1];
        Float price = Float.parseFloat(productInformations[2]);
        Float weight = Float.parseFloat(productInformations[3]);
        String color = productInformations[4];
        int productCount = Integer.parseInt(productInformations[5]);
        String size = productInformations[6];
        String material = productInformations[7];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }


}
