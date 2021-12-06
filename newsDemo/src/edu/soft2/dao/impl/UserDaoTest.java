package edu.soft2.dao.impl;

import edu.soft2.dao.UserDao;
import edu.soft2.impl.UserDaoImpl;

public class UserDaoTest {
    public static void main(String[] args) {
    UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.findUser("peter","123"));
    }
}
