<%@ page import="edu.soft2.dao.UserDao" %>
<%@ page import="edu.soft2.pojo.User" %>
<%@ page import="edu.soft2.impl.UserDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: samsg
  Date: 2021/9/23
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1.接收index.jsp的数据(username、upwd)
    String username = request.getParameter("username");
    String upwd = request.getParameter("upwd");
//    String att = request.getParameter("att");
    System.out.println("username=" + username+",upwd="+upwd);
    //2.查询数据库news_user表，有否数据(username、upwd)
    UserDao userDao = new UserDaoImpl();//接口多态实现
    User user = userDao.findUser(username,upwd);
    //3.判定后跳转
    if (user == null) {
        //跳转回去
        response.sendRedirect("../index.jsp");
    }else{
        //user对象放入session中
        session.setAttribute("logonUser",user);
        //跳转至登录页
        response.sendRedirect("do_news_list.jsp");
    }
%>
</body>
</html>
