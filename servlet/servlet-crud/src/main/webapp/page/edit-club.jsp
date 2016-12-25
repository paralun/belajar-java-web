<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Club</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value="library/css/bootstrap.min.css" />" >
        <link rel="stylesheet" href="<c:url value="library/css/bootstrap-theme.min.css" />" >
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h1>Tambah Club</h1>
                    <form action="edit-club" method="post">
                        <input type="hidden" name="id" value="${club.id}">
                        <div class="form-group">
                            <label for="nama">Nama Club</label>
                            <input type="text" class="form-control" id="nama" name="nama" value="${club.namaClub}">
                        </div>
                        <div class="form-group">
                            <label for="stadion">Stadion</label>
                            <input type="text" class="form-control" id="stadion" name="stadion" value="${club.stadion}">
                        </div>
                        <button type="submit" class="btn btn-default">Simpan</button>
                    </form>
                </div>
            </div>
        </div>
                    
        <script type="text/javascript" src="<c:url value="library/js/bootstrap.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="library/js/jquery-2.1.4.min.js" />"></script>
    </body>
</html>
