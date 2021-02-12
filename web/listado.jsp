<%-- 
    Document   : listado
    Created on : 11/02/2021, 02:02:09 PM
    Author     : salvarez
--%>

<%@page import="java.util.List"%>
<%@page import="dto.ContactPerson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="contacrPerson" class="JavaBean.ContactNameBean" scope="request"></jsp:useBean>
<%
    List<ContactPerson> list =  contacrPerson.findAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listado de Productos</title>
    </head>
    <body>
        <h3>Listado de Productos</h3>
        <p><a href="<%=request.getContextPath()%>/formulario.jsp">Agregar Persona (+)</a></p>
        <table>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Lastname</th>
                <th>Cellphone</th>
                <th>Edit</th>
                <th>Remove</th>
            </tr>
            <% for (ContactPerson cp : list) {%>
            <tr>
                <td><%= cp.getId() %></td>
                <td><%= cp.getName()%></td>
                <td><%= cp.getLastname()%></td>
                <td><%= cp.getContactName()%></td>
                <td><%= cp.getDescription()%></td>
                <td><a href="<%= request.getContextPath()%>/formulario.jsp?id=<%= cp.getId()%>">
                        editar</a></td>
                <td><a onclick="return confirm('Esta seguro?');"  href="<%= request.getContextPath()%>/eliminar.jsp?contactName=<%= cp.getId()%>&id=<%= cp.getId()%>">
                        eliminar</a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
