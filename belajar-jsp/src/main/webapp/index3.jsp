<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Belajar JSP</title>
    </head>
    <body>
        <h2>HTTP Header Request Example</h2>
        <% 
            Enumeration headerName = request.getHeaderNames();
            while(headerName.hasMoreElements()) {
                String paramName = (String) headerName.nextElement();
                String paramValue = request.getHeader(paramName);
                out.println("Param Name : " + paramName);
                out.println("Param Value : " + paramValue);
            }
        %>
    </body>
</html>
