package entity;

public class Items {
    private int itemId;
    private String item;
    private int itemPrice;

    public Items() {
    }

    public Items(int itemId, String item, int itemPrice) {
        this.itemId = itemId;
        this.item = item;
        this.itemPrice = itemPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

}
