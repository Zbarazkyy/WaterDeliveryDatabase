package service;

import dao.ItemsDAO;
import entity.Items;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsService implements ItemsDAO {
    Connection connection = null;

    @Override
    public List<Items> getAllItems() {
        PreparedStatement preparedStatement = null;
        List<Items> itemsList = new ArrayList<>();
        String sql = "SELECT * FROM items;";
        try {
            connection = ConnectionManager.open();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int itemId = resultSet.getInt(1);
                String item = resultSet.getString(2);
                int itemPrice = resultSet.getInt(3);
                Items items = new Items(itemId, item, itemPrice);
                itemsList.add(items);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && preparedStatement != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return itemsList;
    }

    @Override
    public int getItemsID(String items) {
        Statement statement = null;
        int itemId = 0;
        String sql = "SELECT item_id " +
                     "FROM items " +
                     "WHERE item = '" + items + "';";

        try {
            connection = ConnectionManager.open();
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                itemId = resultSet.getInt(1);
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
        return itemId;
    }
}
