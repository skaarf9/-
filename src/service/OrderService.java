package service;

import entity.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * @author skaarf9
 */
public interface OrderService {

    public List<Order> getAllByPage(int page) throws SQLException;
    public boolean addOne(Order order);
    public boolean deleteByID(int id);
    public boolean alterByID(int id,Order order);
    public List<Order> querySelector(String info) throws SQLException;
}
