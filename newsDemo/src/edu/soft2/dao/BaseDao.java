package edu.soft2.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;

    /**
     * 获取数据库连接对象
     * @return
     */
    public boolean getConnection(){
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/qqZone");
            conn = ds.getConnection();
            System.out.println("conn = "+conn);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 释放数据库连接资源(Connection对象、PreparedStatement对象、ResultSet对象)
     */
    public void closeResource(){
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

    //数据库查询通用方法
    public ResultSet executeSQL(String sql,Object[] params){
        if (getConnection()) {//数据库连接已开
            try {
                ps = conn.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1,params[i]);//ps设置占位符
                }
                rs = ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
    //数据库增删改的通用方法
    public boolean executeUpdate(String sql, Object[] params){
        if (getConnection()) {//数据库连接已开
            try {
                ps = conn.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
