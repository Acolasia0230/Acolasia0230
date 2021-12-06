<%@page import="edu.soft2.dao.NewsDao"%>
<%@page import="edu.soft2.pojo.Topic"%>
<%@page import="edu.soft2.dao.TopicDao"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="edu.soft2.dao.impl.TopicDaoImpl" %>
<%	
	request.setCharacterEncoding("utf-8");
	String opr = request.getParameter("opr");//从地址栏解析获取opr参数的值
	TopicDao topicDao = new TopicDaoImpl();//创建TopicDao

	 if(opr.equals("list")){//展示主题
		List<Topic> list4 = topicDao.findAllTopic();
		session.setAttribute("list4",list4);
		response.sendRedirect("../newspages/topic_list.jsp");
	}else if(opr.equals("add")){//添加主题
		String tname = request.getParameter("tname");
		Topic topic= (Topic) topicDao.findTopicByName(tname);
		if(topic==null){//没有此topic主题
			topicDao.addTopic(tname);//执行添加
			List<Topic> list4 = topicDao.findAllTopic();
			session.setAttribute("list4",list4);//所有的主题		
			%>
			<script type="text/javascript">
			alert("当前主题创建成功，点击确认返回主题列表！");
			location.href="topic_ control.jsp?opr=list";
			</script>
<%			
		}else{%>
		    <script type="text/javascript">
			alert("当前主题已存在，请输入不同的主题！");
			location.href="../newspages/topic_add.jsp";	
			</script>
<%			
		}
	}else if(opr.equals("update")){//修改主题
		String tid = request.getParameter("tid");
		String tname = request.getParameter("tname");
		if(topicDao.updateTopic(tid,tname)){//修改成功
			%>
			<script type="text/javascript">
			alert("当前主题修改成功，点击确认返回主题列表！");
			location.href="topic_ control.jsp?opr=list";
			</script>
		<%}else{%>
		<script type="text/javascript">
			alert("当前主题修改失败，点击确认返回主题列表！");
			location.href="topic_ control.jsp?opr=list";
		</script>
		<%}
	}else if(opr.equals("del")){//删除主题
	 	String tid = request.getParameter("tid");
	 	if(topicDao.delTopic(tid)){%>
		<script type="text/javascript">
			alert("当前主题删除成功，点击确认返回主题列表！");
			location.href="topic_ control.jsp?opr=list";
		</script>
		<%}else{%>
		<script type="text/javascript">
			alert("当前主题删除失败，点击确认返回主题列表！");
			location.href="topic_ control.jsp?opr=list";
		</script>
		<%}
	}else{%>
<script type="text/javascript">
	alert("oops!页面跳转错误，返回");
	location.href="../newspages/admin.jsp";
</script>
  <%}%>
