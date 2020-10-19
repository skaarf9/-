package service.impl;

import entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        List<Order> orderList = new ArrayList<Order>();
        orderList = new OrderServiceImpl().querySelector("4");
        Iterator<Order> it = orderList.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getdAddress());
        }
        System.out.println("finish");
    }
}
