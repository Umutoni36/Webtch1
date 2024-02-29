<%@page import="com.javapoint.dao.UserDao"%>  
<jsp:useBean id="u" class="com.javapoint.bean.user"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
int i=UserDao.update(u);  
response.sendRedirect("viewusers.jsp");  
%>  