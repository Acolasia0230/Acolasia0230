package edu.soft2.dao;

import edu.soft2.pojo.News;

import java.util.List;

public interface NewsDao {
    /**
     * 查询news表中所有数据
     * @return
     */
    public List<News> findAllNews();
}
