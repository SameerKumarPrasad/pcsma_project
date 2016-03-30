package com.aircanteen;

import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kartik on 31/3/16.
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    private static List<Item> items;
    private static final AtomicLong counter = new AtomicLong();

    static {
        items = populateDummyItems();
    }

    private static List<Item> populateDummyItems() {
        System.out.println("Items going in");
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(counter.incrementAndGet(), "Burger", 35, 10, true, "VEG", 1));
        items.add(new Item(counter.incrementAndGet(), "Chicken Burger", 35, 10, true, "NON-VEG", 1));
        //users.add(new User(counter.incrementAndGet(), "Tom", "tompassword", true));
        return items;
    }

    @Override
    public Item findById(long id) {
        return null;
    }


    @Override
    public Item findByName(String name) {
        for(Item item : items){
            if(item.getName().equalsIgnoreCase(name)){
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Item> findAllItems() {
        return items;
    }

    @Override
    public void saveItem(Item item) {
        item.setId(counter.incrementAndGet());
        items.add(item);
    }

    @Override
    public boolean isItemExist(Item item) {
        return findByName(item.getName())!=null;
    }

}
