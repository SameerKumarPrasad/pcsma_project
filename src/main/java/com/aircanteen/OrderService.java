package com.aircanteen;

import java.util.List;

/**
 * Created by kartik on 31/3/16.
 */
public interface OrderService {
    Item findById(long id);
    List<Item> findAllItems();

    public Item findByName(String name);
    void saveItem(Item item);
    public boolean isItemExist(Item item);
}
