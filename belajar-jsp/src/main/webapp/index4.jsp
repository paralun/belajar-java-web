<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>JSP Standard Tag Library</h2>

        <c:out value="Hello" />
        <c:set var="salary" scope="session" value="${2000*5}" />
        <c:out value="${salary}" />
        <c:remove var="salary" />
        <p>After Remove Value : <c:out value="${salary}" /></p>

        <c:set var="angka" value="3" />
        <c:if test="${angka % 2 == 0}">
            <p>Bilangan Genap</p>
        </c:if> 

        <c:set var="nilai" value="90" /> 
        <c:choose>
            <c:when test="${nilai <= 60}">
                <b>Cukup</b>
            </c:when>
            <c:when test="${nilai <= 80}">
                <b>Baik</b>
            </c:when>
            <c:otherwise>
                <b>Sangat Baik</b>
            </c:otherwise>
        </c:choose>

        <c:forEach var="i" begin="1" end="5">
            Item : <c:out value="${i}" /> <br>
        </c:forEach>

        <c:forTokens items="Jaja,Baba,Tata" delims="," var="nama">
            <c:out value="${nama}" /> <br>
        </c:forTokens>

        <a href="<c:url value="index.jsp" />">Index</a>
    </body>
</html>
