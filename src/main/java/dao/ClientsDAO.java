package dao;

import entity.Clients;

import java.util.List;

public interface ClientsDAO {

    void addClients(Clients client);

    List<Clients> getAllClients();

    int getClientId(String fName);

    List<Clients> getClientById(int clientId);


    void remove(Clients clients);

}
