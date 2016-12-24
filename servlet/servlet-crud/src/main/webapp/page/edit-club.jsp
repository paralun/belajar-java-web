<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tambah Club</h1>
        <form action="edit-club" method="post">
            <input type="hidden" name="id" value="${club.id}">
            <table>
                <tbody>
                    <tr>
                        <td>Nama Club</td>
                        <td><input type="text" name="nama" value="${club.namaClub}"></td>
                    </tr>
                    <tr>
                        <td>Stadion</td>
                        <td><input type="text" name="stadion" value="${club.stadion}"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" value="Simpan" ></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
