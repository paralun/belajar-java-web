<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Selamat Datang</title>
    </head>
    <body>
        Welcome ${sessionScope['username']} <br />
        <form action="logout" method="post">
            <input type = "submit" value = "Logout"/>
        </form>
    </body>
</html>
