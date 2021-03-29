package service;

import dao.OrdersDAO;
import entity.Orders;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersService implements OrdersDAO {

    Connection connection = null;

    @Override
    public void addOrder(Orders order) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO orders " +
                     "(order_id, item_id, client_id, quantity, orders_date, user_id) " +
                     "VALUES" +
                     " (?,?,?,?,?,?);";
        try {
            connection = ConnectionManager.open();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, order.getOrderId());
            preparedStatement.setInt(2, order.getItemId());
            preparedStatement.setInt(3, order.getClientId());
            preparedStatement.setInt(4, order.getQuantity());
            preparedStatement.setDate(5, order.getOrdersDate());
            preparedStatement.setInt(6, order.getUserId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null && connection != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Orders> getAllOrders() {
        Statement statement = null;

        List<Orders> ordersList = new ArrayList<>();
        String sql = "SELECT order_id, item_id, client_id, quantity, orders_date, user_id FROM orders;";

        try {
            connection = ConnectionManager.open();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int orderId = resultSet.getInt(1);
                int itemId = resultSet.getInt(2);
                int clientId = resultSet.getInt(3);
                int quantity = resultSet.getInt(4);
                Date ordersDate = resultSet.getDate(5);
                int userId = resultSet.getInt(6);

                Orders orders = new Orders();
                orders.setOrderId(orderId);
                orders.setItemId(itemId);
                orders.setClientId(clientId);
                orders.setQuantity(quantity);
                orders.setOrdersDate(ordersDate);
                orders.setUserId(userId);

                ordersList.add(orders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null && connection != null) {
                    statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ordersList;
    }

    @Override
    public int getMaxOrderID(Orders order) {
        Statement statement = null;
        int maxId = 0;
        List<Orders> ordersList = new ArrayList<>();
        String sql = "SELECT MAX(order_id) FROM orders;";
        try {
            connection = ConnectionManager.open();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                maxId = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null && connection != null) {
                    statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return maxId;
    }

    @Override
    public List<Orders> getOrdersByClint(int client) {
        return null;
    }
}
