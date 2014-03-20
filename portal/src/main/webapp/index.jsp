<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	String ruta = request.getContextPath();
	response.sendRedirect(ruta + "/pages/index.jsf");
%>
