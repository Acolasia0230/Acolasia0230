<%@ page import="edu.soft2.pojo.News" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.soft2.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>添加主题--管理后台</title>
    <link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
    <div id="welcome">欢迎使用新闻管理系统！</div>
    <div id="nav">
        <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
        <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
    </div>
</div>
<div id="admin_bar">
    <div id="status">管理员：
        <%
            String username = ((User)session.getAttribute("logonUser")).getUsername();
        %>
        <%=username%>
        登录  &#160;&#160;&#160;&#160; <a href="#">login out</a></div>
    <div id="channel"> </div>
</div>
<div id="main">
    <%@include file="console_element/left.html" %>
    <div id="opt_area">
        <script language="javascript">
            function clickdel(){
                return confirm("删除请点击确认");
            }
        </script>
        <ul>
            <li>标题：${allNews[0].["nTitle"]}</li>
            <li>创建时间：${allNews[0].["ncreateDate"]}</li>
        </ul>

        <ul class="classlist">
            <%
                //1.获取session中的list
                List<News> list = (List<News>) session.getAttribute("allNews");
                //2.解析list，将其中的News对象显示到页面中
                if(list==null){
                    response.sendRedirect("../util/do_news_list.jsp");
                    return;
                }else{
                    session.removeAttribute("list");
                    int n=0;
                    for(News tempNews:list){
                        n++;
            %>
            <li><%=tempNews.getNTitle() %>&#160;&#160;<%=tempNews.getNContent() %>
                <span> 作者：<%=tempNews.getNAuthor() %> &#160;&#160;&#160;&#160;
                  <a href='#'>修改</a> &#160;&#160;&#160;&#160;
                  <a href='#' onclick='return clickdel()'>删除</a>
              </span>
            </li>
            <%if(n%5==0){ %>
            <li class='space'></li>
            <%}} }%>
        </ul>
    </div>
</div>
<div id="footer">
    <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>

