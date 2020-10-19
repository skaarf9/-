package service.impl;

import entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author skaarf9
 * @date 2020/10/18
 */
public class OrderServiceImpl  implements service.OrderService {
    @Override
    public List<Order> getAllByPage(int page) throws SQLException {
        int maxline = 10;
        String sql = "SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM myorder t WHERE ROWNUM <= ?) table_alias WHERE table_alias.rowno >= ?";
        ResultSet resultSet = Util.executeQuery(sql, maxline * page, maxline * (page - 1) + 1);
        List<Order> orderList = new ArrayList<Order>();
        assert resultSet != null;
        while(resultSet.next()){
            Order order = new Order();
            order.setId(resultSet.getInt("ID"));
            order.setdAddress(resultSet.getString("dAddress"));
            order.setdGoods(resultSet.getInt("dGoods"));
            order.setdNum(resultSet.getInt("dNum"));
            order.setdTime(resultSet.getString("dTime"));
            order.setdStatus("Y".equals(resultSet.getString("dStatus").toUpperCase()));
            order.setpStatus("Y".equals(resultSet.getString("pStatus").toUpperCase()));
            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public boolean addOne(Order order) {
        String sql = "insert into myorder values(?,?,?,?,?,?,?)";
        return Util.executeUpdate(sql, order.getId(),order.isdStatus(),order.getdAddress(),order.getdGoods(),order.getdNum(),order.ispStatus(),order.getdTime());
    }

    @Override
    public boolean deleteByID(int id) {
        String sql = "delete from myorder where id = ?";
        return Util.executeUpdate(sql,id);
    }

    @Override
    public boolean alterByID(int id, Order order) {
        String sql = "update myorder set ID = ?,Status = ?,DADDRESS = ?, Dgoods = ?,Dnum = ?,Pstatus  =?,Dtime = ? where id = ?)";
        return Util.executeUpdate(sql, order.getId(),order.isdStatus(),order.getdAddress(),order.getdGoods(),order.getdNum(),order.ispStatus(),order.getdTime(),id);
    }

    @Override
    public List<Order> querySelector(String info) throws SQLException {
        String sql;
        sql = "select * from myorder where to_char(ID) like ? or DStatus like ? or Daddress like ? or to_char(Dgoods) like ? or to_char(Dnum) like ? or Pstatus like ? or to_char(Dtime) like ?";
        info = "%" + info + "%";
        ResultSet resultSet = Util.executeQuery(sql, info,info,info,info,info,info,info);
        List<Order> orderList = new ArrayList<Order>();
        assert resultSet != null;
        while(resultSet.next()){
            Order order = new Order();
            order.setId(resultSet.getInt("ID"));
            order.setdAddress(resultSet.getString("dAddress"));
            order.setdGoods(resultSet.getInt("dGoods"));
            order.setdNum(resultSet.getInt("dNum"));
            order.setdTime(resultSet.getString("dTime"));
            order.setdStatus("Y".equals(resultSet.getString("dStatus").toUpperCase()));
            order.setpStatus("Y".equals(resultSet.getString("pStatus").toUpperCase()));
            orderList.add(order);
        }
        return orderList;
    }
}
