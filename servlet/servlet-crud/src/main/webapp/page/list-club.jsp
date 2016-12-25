<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Daftar Club</title>
        <link rel="stylesheet" href="<c:url value="library/css/bootstrap.min.css" />" >
        <link rel="stylesheet" href="<c:url value="library/css/bootstrap-theme.min.css" />" >
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-10">
                    <h1 align="center">Daftar Club</h1>
                    <a class="btn btn-primary" href="edit-club" >Add Club</a>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Nama Club</th>
                                <th>Stadion</th>
                                <th>&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="club" items="${clubs}">
                                <tr>
                                    <td>${club.namaClub}</td>
                                    <td>${club.stadion}</td>
                                    <td>
                                        <a class="btn btn-info btn-xs" href="edit-club?id=${club.id}">edit</a>
                                        <a class="btn btn-danger btn-xs" href="delete-club?id=${club.id}">delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="<c:url value="library/js/bootstrap.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="library/js/jquery-2.1.4.min.js" />"></script>
    </body>
</html>
