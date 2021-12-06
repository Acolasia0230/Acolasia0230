package edu.soft2.impl;

import edu.soft2.dao.UserDao;
import edu.soft2.pojo.User;
import edu.soft2.util.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 实现UserDao接口
 */
public class UserDaoImpl implements UserDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public User findUser(String username, String upwd) {
        User user = null;
        try {
            //连接数据库
            Connection conn = DaoFactory.getConn();
            //查询
            PreparedStatement ps = conn.prepareStatement(
            "select * from news_user where username=? and upwd=?");
            ps.setString(1, username);
            ps.setString(2, upwd);
            rs = ps.executeQuery();
            //解析结果集
            while(rs.next()){
                //封装到User对象
            user = new User(
                    rs.getString("uid"),
                    rs.getString("username"),
                    rs.getString("upwd")
            );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.closeConn(rs,ps,conn);//关闭数据库连接
        }
        return user;
    }
}
