package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {

    public static Product stringToProduct(String productString) {
        final char productType = productString.charAt(0);

        switch (productType) {

            case Product.PRODUCT_TYPE:
                return convToProduct(productString);

            case Boots.PRODUCT_TYPE:
                return convToBoots(productString);

            case Cloth.PRODUCT_TYPE:
                return convToCloth(productString);
        }
        return null;
    }


    private static Product convToProduct(String stringToConv) {
        String[] productInformation = stringToConv.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformation[1]);
        String productName = productInformation[2];
        Float price = Float.parseFloat(productInformation[3]);
        Float weight = Float.parseFloat(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    private static Boots convToBoots(String stringToConv) {
        String[] productInformation = stringToConv.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformation[1]);
        String productName = productInformation[2];
        Float price = Float.parseFloat(productInformation[3]);
        Float weight = Float.parseFloat(productInformation[4]);
        String color = productInformation[5];
        int productCount = Integer.parseInt(productInformation[6]);
        int size = Integer.parseInt(productInformation[7]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInformation[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    private static Cloth convToCloth(String stringToConv) {
        String[] productInformations = stringToConv.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        int productCount = Integer.parseInt(productInformations[6]);
        String size = productInformations[7];
        String material = productInformations[8];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }


}
