package dao;

import entity.Orders;

import java.util.List;

public interface OrdersDAO {

    void addOrder(Orders order);

    List<Orders> getAllOrders();

    int getMaxOrderID(Orders order);

    List<Orders> getOrdersByClint(int client);


}
