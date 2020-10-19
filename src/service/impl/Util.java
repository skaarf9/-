package service.impl;

import java.sql.*;
import java.util.ResourceBundle;


/**
 * @author skaarf
 */
public class Util {
    /*
      注册驱动
      静态代码块在类加载的时候执行且只执行一次
     */
    static {
        try {
            Class.forName(ResourceBundle.getBundle("JDBC").getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ResourceBundle bundle = ResourceBundle.getBundle("JDBC");
    public static PreparedStatement pstmt = null;
    public static Connection connection = null;
    public static ResultSet rs = null;

    /**
     * 获取连接对象
     */
    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("password"));
        return connection;
    }

    /**
     *
     * @param sql 执行的sql语句
     * @param params sql语句参数
     * @return boolean
     */
    public static boolean executeUpdate(String sql, Object... params) {
        try{
            pstmt = getConnection().prepareStatement(sql);
            if(params!=null){
                for(int i = 0;i < params.length;i++){
                    pstmt.setObject(i+1, params[i]);
                }
            }
            int count = pstmt.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(null, pstmt, connection);
        }
        return false;
    }

    /**
     *
     * @param sql 执行的sql语句
     * @param params sql语句参数
     * @return ResultSet
     */
    public static ResultSet executeQuery(String sql, Object... params) {
        try{
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            if(params!=null){
                for(int i = 0;i < params.length;i++){
                    pstmt.setObject(i+1, params[i]);
                }
            }
            rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源
     * @param rs 结果集
     * @param ps 数据库操作对象
     * @param conn 数据库连接对象
     */
    public static void close(ResultSet rs, Statement ps, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询后执行的释放资源方法(数据处理后手动调用)
     */
    public static void close(){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
