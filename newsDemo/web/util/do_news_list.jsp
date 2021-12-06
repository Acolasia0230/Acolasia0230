<%@ page import="edu.soft2.dao.NewsDao" %>
<%@ page import="edu.soft2.pojo.News" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.soft2.dao.impl.NewsDaoImpl" %>
<%
    //1.查询所有的News，使用NewsDao的findAllNews()方法
    NewsDao newsDao = new NewsDaoImpl();
    List<News> list = newsDao.findAllNews();
    //2.将查询的list放入session
    session.setAttribute("allNews",list);
    //3.跳转至/newspages/admin.jsp
    response.sendRedirect("../newspages/admin.jsp");
%>
</body>
</html>
