<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>SpringBoot</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
            width: 150px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h2>HTML Table</h2>

<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Action</th>
    </tr>
    <c:forEach var = "listitem" items = "${employeelist}">
        <tr>
            <td>${listitem.getFirstName()}</td>
            <td>${listitem.getLastName()}</td>
            <td>
                <a href="/view/${listitem.getId()}">View</a>
                <a href="/edit/${listitem.getId()}">Edit</a>
                <a href="/delete/${listitem.getId()}"><img src="../../img/delete.jpg" alt="delete_image" ></a>
            </td>
        </tr>
    </c:forEach>
</table>

<form method="post" action="/save">
    <input type="hidden" name="id" value="">
    First name:<br>
    <input type="text" name="firstname">
    <br>
    Last name:<br>
    <input type="text" name="lastname" >
    <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
