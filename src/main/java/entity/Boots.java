package entity;


public class Boots extends Product {

    public final static char PRODUCT_TYPE = 'B';

    private int size;
    private boolean isNaturalSkin;

    public int getSize() {
        return size;
    }

    public boolean getIsNaturalSkin() {
        return isNaturalSkin;
    }

    public Boots(Long id, String productName, Float price, Float weight, String color, int productCount, int size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public String getBasicBootsString() {
        return super.toString() + Product.PRODUCT_SEPARATOR + size + Product.PRODUCT_SEPARATOR + isNaturalSkin;
    }

    @Override
    public String toString() {
        return PRODUCT_TYPE + PRODUCT_SEPARATOR + getBasicBootsString();
    }
}
