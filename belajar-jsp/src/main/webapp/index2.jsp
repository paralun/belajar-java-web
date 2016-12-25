<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! int value = 2; %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Belajar JSP</title>
    </head>
    <body>
        <% if(value % 2 == 0) { %>
            <b>Bilangan Genap</b>
        <% }else {  %>
            <b>Bilangan Ganjil</b>
        <% }  %>
        
        <% for(int x=1; x <= 10; x++) { %>
            <font color="red" size="<%= x %>">Hallo</font> <br>
        <% } %>
    </body>
</html>
