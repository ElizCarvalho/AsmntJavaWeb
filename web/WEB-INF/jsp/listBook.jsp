<%-- 
    Document   : listaAluno
    Created on : 16/02/2017, 07:47:07
    Author     : DesenvolvedorJava
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library - Books List</title>
    </head>
    <body>
        <h1>Books List</h1>
        <hr/>
        <a href="index.htm"> << Back </a>
        <br/>
        <table border="1">
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
                        <td>${book.idbook}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.publishingcomp}</td>
                        <td>${book.releaseyear}</td>
                        <td>
                            <form action=".htm" method="POST">
                                <input type="hidden" name=""/>
                            </form>
                        </td>
                        <td><a href="deleteBook?id=${book.idbook}">Delete</a></td>

                    </tr>
                </c:forEach>
                
            </tbody>            
        </table>
        
    </body> 
</html>
