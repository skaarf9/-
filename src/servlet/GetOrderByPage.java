package servlet;

import com.alibaba.fastjson.JSONArray;
import entity.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Administrator
 */
@WebServlet("/GetOrderByPage")
public class GetOrderByPage extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int Page =Integer.parseInt(request.getParameter("Page"));
        OrderService orderService = new OrderServiceImpl();
        List<Order> orders = null;
        try {
            orders = orderService.getAllByPage(Page);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Object obj2 = JSONArray.toJSON(orders);
        String jsonString = obj2.toString();
        OutputStream out = response.getOutputStream();
        out.write(jsonString.getBytes("UTF-8"));
        out.flush();
    }
}
