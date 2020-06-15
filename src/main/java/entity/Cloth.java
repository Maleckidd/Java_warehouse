package entity;


public class Cloth extends Product {

    public final static char PRODUCT_TYPE = 'C';

    private String size;
    private String material;

    public String getMaterial() {
        return material;
    }

    public String getSize() {
        return size;
    }

    public Cloth(Long id, String productName, Float price, Float weight, String color, int productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getBasicClothString() {
        return super.toString() + Product.PRODUCT_SEPARATOR + size + Product.PRODUCT_SEPARATOR + material;
    }

    @Override
    public String toString() {
        return PRODUCT_TYPE + PRODUCT_SEPARATOR + getBasicClothString();
    }
}
