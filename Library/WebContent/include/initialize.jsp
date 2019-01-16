<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="dataHandler" class="data_handling.DataHandler" scope="application" />
<%!
public void jspInit(){
	data_handling.DataHandler dh = new data_handling.DataHandler();
	dh.createTables();
}
%>>
