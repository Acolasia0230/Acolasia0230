package edu.soft2.dao.impl;

import edu.soft2.dao.TopicDao;
import edu.soft2.pojo.Topic;
import edu.soft2.util.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现TopicDao的类
 */
public class TopicDaoImpl implements TopicDao {
    Topic topic = null;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    @Override
    public List<Topic> findAllTopic() {
        List<Topic> list = new ArrayList<Topic>();
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("select * from topic");
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Topic(
                        rs.getString("tid"),
                        rs.getString("tname")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.closeConn(rs,ps,conn);//关闭数据库连接
        }
        return list;
    }

    @Override
    public Topic findTopicByName(String tname) {

        ResultSet rs = null;
        try {
            conn = DaoFactory.getConn();
            ps = conn.prepareStatement("select * from topic where tname=?");
            ps.setString(1,tname);
            rs = ps.executeQuery();
            while(rs.next()){
                topic = new Topic(
                        rs.getString("tid"),
                        rs.getString("tname")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.closeConn(rs, ps, conn);//关闭数据库连接
        }
        return topic;
    }


    @Override
    public boolean addTopic(String tname) {
        int rows = 0;
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("insert into topic(tname) values(?)");
            ps.setString(1, tname);
            rows = ps.executeUpdate();//返回执行的结果
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.closeConn(rs,ps,conn);//关闭数据库连接
        }
        if (rows != 0 && rows != -1) {//更新成功
            return true;
        }
        return false;
    }

    @Override
    public boolean delTopic(String tid) {
        int rows = 0;
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("delete from topic where tid = ?");
            ps.setString(1,tid);
            rows = ps.executeUpdate();
            if (rows != 0 && rows != -1) {//更新成功
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.closeConn(rs,ps,conn);//关闭数据库连接
        }
        return false;
    }

    @Override
    public boolean updateTopic(String tid, String tname) {
        int rows = 0;
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("update topic set tname=? where tid = ?");
            ps.setString(1,tname);
            ps.setString(2, tid);
            rows = ps.executeUpdate();
            if (rows != 0 && rows!=-1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.closeConn(rs,ps,conn);//关闭数据库连接
        }
        return false;
    }
}
