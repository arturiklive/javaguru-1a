package model;

public class ShopItem {
    private String itemType;
    private String brand;
    public ShopItem(String itemType, String brand) {
        this.itemType = itemType;
        this.brand = brand;
    }
    public String getItemType() {
        return itemType;
    }
    public String getBrand() {
        return brand;
    }
}
