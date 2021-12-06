package edu.soft2.dao.impl;

import edu.soft2.dao.NewsDao;
import edu.soft2.pojo.News;
import edu.soft2.util.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 实现NewsDao的类
 */
public class NewsDaoImpl implements NewsDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<News> findAllNews() {
        List<News> list = new ArrayList<News>();
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("select * from news");
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new News(
                        rs.getString("nId"),
                        rs.getString("nTid"),
                        rs.getString("nTitle"),
                        rs.getString("nAuthor"),
                        rs.getString("nCreateDate"),
                        rs.getString("nPicPath"),
                        rs.getString("nContent"),
                        rs.getString("nModifyDate"),
                        rs.getString("nSummary")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DaoFactory.closeConn(rs,ps,conn);
        }
        return list;
    }
}
