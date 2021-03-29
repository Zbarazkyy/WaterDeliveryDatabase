package dao;

import entity.Items;

import java.util.List;

public interface ItemsDAO {

    List<Items> getAllItems();

    int getItemsID(String items);

}
