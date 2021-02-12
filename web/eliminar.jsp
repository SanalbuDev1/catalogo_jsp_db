<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<jsp:useBean id="producto" class="JavaBean.ContactNameBean" scope="request"></jsp:useBean>

<jsp:setProperty property="id" name="producto" />
<%
    out.print(producto);
    
    producto.delete(request.getParameter("id"));

    //response.sendRedirect(request.getContextPath() + "/listado.jsp");
%>
