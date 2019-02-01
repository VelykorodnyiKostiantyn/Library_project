<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="data_handling.model.*" import= "data_handling.*" import= "data_handling.service.*" %>
<%@ page import="org.springframework.context.ApplicationContext" import="org.springframework.context.support.ClassPathXmlApplicationContext" %>

<%!
public void jspInit(){
	if (ApplicationContextProvider.getApplicationContext() == null){
	ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
	data_handling.DBInit db = ApplicationContextProvider.getApplicationContext().getBean(DBInit.class);
	db.dropTables();
	db.createTables();
	System.out.println("Database initialized");
	}
}
%>
