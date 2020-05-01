package entity;

public class Boots extends Product {
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

    @Override
    public String toString() {
        return "Boots{" +
                "size=" + size +
                ", isNaturalSkin=" + isNaturalSkin +
                '}';
    }
}
