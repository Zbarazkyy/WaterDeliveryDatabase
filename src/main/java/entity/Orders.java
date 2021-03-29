package entity;

import java.sql.Date;

public class Orders {

    private int orderId;
    private int itemId;
    private int clientId;
    private int quantity;
    private Date ordersDate;
    private int userId;

    public Orders() {
    }

    public Orders(int orderId, int itemId, int clientId, int quantity, Date ordersDate, int userId) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.clientId = clientId;
        this.quantity = quantity;
        this.ordersDate = ordersDate;
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(Date ordersDate) {
        this.ordersDate = ordersDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
