package service;

import dao.ClientsDAO;
import entity.Clients;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsService implements ClientsDAO {

    Connection connection = null;

    @Override
    public void addClients(Clients client) {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO clients" +
                     "(f_name, l_name, address_city, address_street, address_house, address_flat, address_notes, phone_1, phone_2, phone_3, user_id ) " +
                     "VALUES" +
                     " (?,?,?,?,?,?,?,?,?,?,?);";
        try {
            connection = ConnectionManager.open();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, client.getfName());
            preparedStatement.setString(2, client.getlName());
            preparedStatement.setString(3, client.getAddressCity());
            preparedStatement.setString(4, client.getAddressStreet());
            preparedStatement.setString(5, client.getAddressHouse());
            preparedStatement.setString(6, client.getAddressFlat());
            preparedStatement.setString(7, client.getAddressNotes());
            preparedStatement.setInt(8, client.getPhone1());
            preparedStatement.setInt(9, client.getPhone2());
            preparedStatement.setInt(10, client.getPhone3());
            preparedStatement.setInt(11, client.getUserId());

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
    public List<Clients> getAllClients() {
        List<Clients> clientsList = new ArrayList<>();
        Statement statement = null;

        String sql = "SELECT client_id, f_name, l_name, address_city, address_street, address_house, address_flat, address_notes,  phone_1, phone_2, phone_3 " +
                     "FROM clients; ";

        try {
            connection = ConnectionManager.open();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int clientId = resultSet.getInt("client_id");
                String fName = resultSet.getString("f_name");
                String lName = resultSet.getString("l_name");
                String addressCity = resultSet.getString("address_city");
                String addressStreet = resultSet.getString("address_street");
                String addressHouse = resultSet.getString("address_house");
                String addressFlat = resultSet.getString("address_flat");
                String addressNotes = resultSet.getString("address_notes");
                int phone1 = resultSet.getInt("phone_1");
                int phone2 = resultSet.getInt("phone_2");
                int phone3 = resultSet.getInt("phone_3");


                Clients clients = new Clients();
                clients.setClientId(clientId);
                clients.setfName(fName);
                clients.setlName(lName);
                clients.setAddressCity(addressCity);
                clients.setAddressStreet(addressStreet);
                clients.setAddressHouse(addressHouse);
                clients.setAddressFlat(addressFlat);
                clients.setAddressNotes(addressNotes);
                clients.setPhone1(phone1);
                clients.setPhone2(phone2);
                clients.setPhone3(phone3);

                clientsList.add(clients);
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
        return clientsList;
    }

    @Override
    public int getClientId(String lName) {
        int clientId = 0;

        Statement statement = null;
        String sql = "SELECT client_id " +
                     "FROM clients " +
                     "WHERE f_name = '" + lName + "';";
        try {
            connection = ConnectionManager.open();
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                clientId = resultSet.getInt("client_id");
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
        return clientId;
    }

    @Override
    public List<Clients> getClientById(int clientId) {
        List<Clients> clientsList = null;

        Statement statement = null;
        String sql = "SELECT f_name, l_name, address_city, address_street, address_house, address_flat, address_notes, phone_1, phone_2, phone_3 " +
                     "FROM clients WHERE client_id = '" + clientId + "'; ";

        try {
            connection = ConnectionManager.open();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String fName = resultSet.getString(1);
                String lName = resultSet.getString(2);
                String addressCity = resultSet.getString(3);
                String addressStreet = resultSet.getString(4);
                String addressHouse = resultSet.getString(5);
                String addressFlat = resultSet.getString(6);
                String addressNotes = resultSet.getString(7);
                int phone1 = resultSet.getInt(8);
                int phone2 = resultSet.getInt(9);
                int phone3 = resultSet.getInt(10);
                Clients clients = new Clients(fName, lName, addressCity, addressStreet, addressHouse, addressFlat, addressNotes, phone1, phone2, phone3);

                clientsList.add(clients);
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
        return clientsList;
    }

    @Override
    public void remove(Clients clients) {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM clients WHERE l_name = ?;";
        try {
            connection = ConnectionManager.open();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, clients.getlName());
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
}
