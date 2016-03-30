package com.aircanteen;

import java.util.ArrayList;
import java.util.*;
import com.aircanteen.Item;

/**
 * Created by nikhil on 29/3/16.
 */
public class Order {
    HashMap<Item,Integer> items;
    Date orderTime;
    String type;

    public Order(HashMap<Item,Integer> items, Date orderTime, String type) {
        this.items = items;
        this.orderTime = orderTime;
        this.type = type;
    }
}
