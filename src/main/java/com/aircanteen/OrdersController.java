package com.aircanteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kartik on 31/3/16.
 */
@RestController
public class OrdersController {


    @Autowired
    OrderService orderService;  //Service which will do all data retrieval/manipulation work

    //-------------------See all items--------------------------------------------------------

    @RequestMapping(value = "/items/", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> listAllItems() {
        System.out.println("See all items");
        List<Item> items = orderService.findAllItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getName());
        }
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @RequestMapping(value = "/items/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Item item, UriComponentsBuilder ucBuilder) {
        System.out.println("Create item");

        if (orderService.isItemExist(item)) {
            System.out.println("A item with name " + item.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        orderService.saveItem(item);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(item.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
