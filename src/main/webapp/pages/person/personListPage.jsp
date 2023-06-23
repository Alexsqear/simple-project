<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dev.alex.valentey.entity.Person"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person List Page</title>
</head>
<body>

<h1>Person List</h1>

counter = ${counter}
<br>
message = ${message}
<br>
${somePerson}
<br>
second variant
<br>
id = ${somePerson.getPersonId()} | age = ${somePerson.getAge()} ||  name = ${somePerson.getName()}
<br>
third variant
<br>
id = ${persId} | age = ${persAge} ||  name = ${persName}
<br>
<table border="3">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>AGE</th>
    </tr>

    <c:forEach var="currentPerson" items="${personList}">
        <tr>
            <td>${currentPerson.getPersonId()}</td>
            <td>${currentPerson.getName()}</td>
            <td>${currentPerson.getAge()}</td>
            <td>
                <form action="/simple-project/person/update" method="get">
                    <input type="hidden" name="updateIdParam" value ="${currentPerson.getPersonId()}">
                    <button type = "submit">update</button>
                </form>
            </td>
            <td>
                <form action="/simple-project/person/delete" method="get">
                    <input type="hidden" name="deleteIdParam" value ="${currentPerson.getPersonId()}">
                    <button type = "submit">delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="/simple-project/person/create" method="get">
    <button type = "submit">create new person</button>
</form>







<br>
second table
<br>
<table border="3">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>AGE</th>
    </tr>

    <%
      ArrayList<Person> persons= (ArrayList<Person>) request.getAttribute("personList");
      for (Person currentPerson: persons) {
    %>
       <tr>
            <td><%=currentPerson.getPersonId()%></td>
            <td><%=currentPerson.getName()%></td>
            <td><%=currentPerson.getAge()%></td>
       </tr>
    <%}%>
</table>
<br>
<br>
second
<br>


</body>
</html>