<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dev.alex.valentey.entity.Person"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person Update Page</title>
</head>
<body>

<h1>Person Update Page</h1>


<form action="/simple-project/person/update" method="post">
    <input type="number" name="PersonIdParam" value="${person.getPersonId()}" readonly/>
    <input type="text" name="updatedPersonNameParam" value="${person.getName()}"/>
    <input type="number" name="updatedPersonAgeParam" value="${person.getAge()}"/>
    <button type = "submit">update</button>
</form>
<form action="/simple-project/person/create" method="get">
    <button type = "submit">create new person</button>
</form>


</body>
</html>