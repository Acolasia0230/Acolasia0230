package edu.soft2.util;

import java.sql.*;

/**
 * 开启连接、关闭数据库的工具类
 */
public class DaoFactory {
    //开启数据库
    public static Connection getConn(){
        Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/news?"
                                + "useUnicode=true&characterEncoding=utf-8"
                                + "&useSSL=false&serverTimezone=Asia/Shanghai",
                        "root",
                        "");
            } catch (SQLException| ClassNotFoundException e ) {
                e.printStackTrace();
            }
        return conn;
    }
    //关闭数据库
    public static void closeConn(ResultSet rs, PreparedStatement ps,Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
