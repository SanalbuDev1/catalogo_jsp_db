<%-- 
    Document   : guardar
    Created on : 11/02/2021, 03:24:27 PM
    Author     : salvarez
--%>

<%@page import="dto.ContactPerson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="producto" class="JavaBean.ContactNameBean" scope="request"></jsp:useBean>

<jsp:setProperty property="id" name="producto" />

<%
    
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String lastname = request.getParameter("lastname");
    int contactName = Integer.parseInt(request.getParameter("contactName"));
    String description = request.getParameter("description1");
    
    ContactPerson cp = new ContactPerson(id, name, lastname, contactName, description);
    
out.print(id + " " + name + " " + lastname + " " + contactName + " " + description);
    
    

%>

<%
    producto.saveOrUpdate(cp);

    response.sendRedirect(request.getContextPath() + "/listado.jsp");
%>
