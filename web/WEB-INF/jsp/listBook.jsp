<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/recursos/css/main.css" />" rel="stylesheet">
        <title>Library - Book List</title>
        <style>
            fieldset {
		border: 0;
            }
            
            body, input, select, textarea, button {
		font-family: sans-serif;
		font-size: 1em;
            }
	</style>
    </head>
    <body>
        <center>
            <fieldset>
                <h2>Library - Book List</h2>
                <br/>
                <a href="index.htm"> << Back </a>
                <br/><br/>
                <table class="table" cellspacing="0" width="90%" border="1">
                    <thead>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Publishing Company</th>
                        <th>Release Year</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${listBook}" var="book" >
                        <tr>
                            <td align="center">${book.id}</td>
                            <td align="center">${book.title}</td>
                            <td align="center">${book.author.name}</td>
                            <td align="center">${book.pubcomp.name}</td>
                            <td align="center">${book.relyear}</td>
                            <td align="center"><a href="startUpdateBook.htm?id=${book.id}">Update</a></td>
                            <td align="center"><a href="deleteBook.htm?id=${book.id}">Delete</a></td>
                        </tr>
                        </c:forEach>
                
                    </tbody>            
                </table>
            </fieldset>
        </center>
    </body> 
</html>
