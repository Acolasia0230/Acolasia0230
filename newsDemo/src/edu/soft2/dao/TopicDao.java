package edu.soft2.dao;

import edu.soft2.pojo.Topic;

import java.util.ArrayList;
import java.util.List;

public interface TopicDao {
    /**
     * 查询所有主题
     * @return
     */
    public List<Topic> findAllTopic();

    /**
     * 按照tname查询主题
     * @param tname
     * @return
     */
    public Topic findTopicByName(String tname);

    /**
     * 增加主题
     * @param tname
     * @return
     */
    public boolean addTopic(String tname);

    /**
     * 删除主题
     * @param tid
     * @return
     */
    public boolean delTopic(String tid);

    /**
     * 更新主题
     * @param tid
     * @param tname
     * @return
     */
    public boolean updateTopic(String tid, String tname);

}
