<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Daftar Club</h2>
        <a href="edit-club" >Add Club</a>
        <table border="1">
            <thead>
                <tr>
                    <td>Nama Club</td>
                    <td>Stadion</td>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="club" items="${clubs}">
                    <tr>
                        <td>${club.namaClub}</td>
                        <td>${club.stadion}</td>
                        <td>
                            <a href="edit-club?id=${club.id}">edit</a>
                            <a href="delete-club?id=${club.id}">delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
