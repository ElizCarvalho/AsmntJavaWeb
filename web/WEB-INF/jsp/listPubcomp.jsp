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

            .campo {
		margin-bottom: 1em;
            }

            .campo label {
		margin-bottom: 0.2em;
		color: #666;
		display: block;
            }

            .campo input[type="text"], .campo input[type="password"]{
		padding: 0.2em;
		border: 1px solid #CCC;
		box-shadow: 2px 2px 2px rgba(0,0,0,0.2);
		display: block;
            }

            .campo input:focus, .campo select:focus {
            	background: #FFC;
            }

            .botao {
		font-size: 1em;
		background: #F90;
		border: 0;
		margin-bottom: 1em;
		color: #FFF;
		padding: 0.2em 0.6em;
		box-shadow: 2px 2px 2px rgba(0,0,0,0.2);
		text-shadow: 1px 1px 1px rgba(0,0,0,0.5);
            }

            .botao:hover {
		background: #FB0;
		box-shadow: inset 2px 2px 2px rgba(0,0,0,0.2);
		text-shadow: none;
            }

            .botao, select {
		cursor: pointer;
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
                <table>
                    <thead>
                        <th>Id</th>
                        <th>Name</th>
                        <th></th>
                        <th></th>
                    </thead>
                    <tbody>
                        <c:forEach items="${listPubcomp}" var="pubcomp" >
                            <tr>
                                <td align="center">${pubcomp.id}</td>
                                <td align="center">${pubcomp.name}</td>
                                <td><a href="deletePubcomp.htm?id=${pubcomp.id}">Update</a></td>
                                <td><a href="deletePubcomp.htm?id=${pubcomp.id}">Delete</a></td>
                            </tr>
                        </c:forEach>  
                    </tbody>            
                </table>
            </fieldset>
        </center>
    </body> 
</html>
