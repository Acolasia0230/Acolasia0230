package edu.soft2.dao;

import edu.soft2.pojo.User;

public interface UserDao {
    /**
     * 查询是否用户是否存在
     * @param username
     * @param upwd
     * @return
     */
    public User findUser(String username, String upwd);
}
