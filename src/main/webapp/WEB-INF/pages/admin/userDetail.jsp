<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SpringMVC student details</title>

    <!-- Bootstrap  CSS  -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>Student detail</h1>
    <hr/>

    <table class="table table-bordered table-striped">
        <tr>
            <th>Name</th>
            <td>${user.name}</td>
        </tr>
        <tr>
            <th>ID</th>
            <td>${user.id}</td>
        </tr>
        <tr>
            <th>GPA</th>
            <td>${user.gpa}</td>
        </tr>
        <tr>
            <th>Major</th>
            <td>${user.major}</td>
        </tr>
    </table>
</div>

<!-- jQuery -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- Bootstrap  JavaScript file -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>