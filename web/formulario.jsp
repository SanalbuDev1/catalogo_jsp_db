<%-- 
    Document   : formulario
    Created on : 11/02/2021, 02:27:07 PM
    Author     : salvarez
--%>

<%@page import="dto.ContactPerson"%>
<jsp:useBean id="contactName" class="JavaBean.ContactNameBean" scope="request"></jsp:useBean>

<jsp:setProperty property="id" name="contactName" />

<% ContactPerson cp = contactName.findById();

    boolean dato = true;
    if(cp.getName() == null){
        String redirect = application.getContextPath() + "/listado.jsp";
      //  response.sendRedirect(redirect);
        dato = false;
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Formulario Producto</title>
    </head>
    <body>
        <h3>Formulario Producto</h3>
        <%= dato%>
        <%= contactName %>


        <form method="post" action="<%= application.getContextPath()%>/guardar.jsp">
            <input type="hidden" name="id" value="<%=cp.getId()%>"/>
            <table border="1">
                <tbody>
                    <tr>
                        <td><span>Nombre</span></td>
                        <td><input size="40" type="text" name="name" value="<%=cp.getName() == null ? "" : cp.getName()%>"/></td>
                    </tr>
                    <tr>
                        <td><span>Lastname</span></td>
                        <td><input type="text" name="lastname" value="<%=cp.getLastname() == null ? "" : cp.getLastname()%>"/></td>
                    </tr>
                    <tr>
                        <td><span>Contactname</span></td>
                        <td><input type="number" name="contactName" value="<%=cp.getContactName() == 0 ? 0 : cp.getContactName() %>"/></td>
                    </tr>
                    <tr>
                        <td><span>description</span></td>
                        <td><input type="text" name="description1" value="<%=cp.getDescription()== null ? "" : cp.getDescription()%>"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="guardar" value="Guardar"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
