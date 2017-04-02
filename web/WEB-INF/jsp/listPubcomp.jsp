<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/recursos/css/main.css" />" rel="stylesheet">
        <title>Library - Author List</title>
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
                <h2>Library - Publishing Company List</h2>
                <br/>
                <a href="index.htm"> << Back </a>
                <br/><br/>
                <table class="table" cellspacing="0" width="50%" border="1">
                    <thead>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${listPubcomp}" var="pubcomp" >
                            <tr>
                                <td align="center">${pubcomp.id}</td>
                                <td align="center">${pubcomp.name}</td>
                                <td align="center"><a href="showPubcomp.htm?id=${pubcomp.id}">Update</a></td>
                                <td align="center"><a href="deletePubcomp.htm?id=${pubcomp.id}">Delete</a></td>
                            </tr>
                        </c:forEach>  
                    </tbody>            
                </table>
            </fieldset>
        </center>
    </body> 
</html>
