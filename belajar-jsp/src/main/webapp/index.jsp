<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>JSP scriplet</h2>
        <% out.println("IP : " + request.getRemoteAddr()); %>
        <br>
        <jsp:scriptlet>
            out.println("IP2 :" + request.getRemoteAddr());
        </jsp:scriptlet>
        <br>
        
        <h2>JSP Declarations</h2>
        <jsp:declaration>
            int value = 20;
        </jsp:declaration>
        <% out.println("Value : " + value); %>
        <br>
        <%! int value2 = 90; %>
        <% out.println("Value2 : " + value2); %>
        <br>
        
        <h2>JSP Expression</h2>
        <p>
            Date : <jsp:expression>(new java.util.Date())</jsp:expression>
        </p>
        <p>
            Date 2 : <%= (new Date()) %>
        </p>
    </body>
</html>
