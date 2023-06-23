<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dev.alex.valentey.entity.Person"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person Create Page</title>
</head>
<body>

<h1>Person Create Page</h1>


<form action="/simple-project/person/create" method="post">
    <input type="number" name="createPersonIdParam" value="1"/>
    <input type="text" name="createPersonNameParam" value="vova"/>
    <input type="number" name="createPersonAgeParam" value="35"/>
    <button type = "submit">create</button>
</form>
<form action="/simple-project/person/create" method="get">
    <button type = "submit">create new person</button>
</form>


</body>
</html>