<%--
  Created by IntelliJ IDEA.
  User: cptko
  Date: 11.07.2020
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add File</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/file/add" method="post" enctype="multipart/form-data">
        <div class="form-file"><h3>Add your File</h3></div>
        <div class="form-file"><input type="file" class="form-control" name="file"></div>
        <div class="form-file"><input type="submit" class="btn btn-primary" value="Add"></div>
    </form>
</div>
</body>
</html>