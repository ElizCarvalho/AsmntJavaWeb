<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/recursos/css/main.css" />" rel="stylesheet">
        <title>Library - Great!</title>
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
                <h1>Library - Great</h1>
                </br>
                <div class="campo">
                    <label for="text"><c:out value="The user ${user.username} with e-mail ${user.email} was successfully registered!"/></label>
                </div>
                <br/><br/>
                <a href="login.htm"> -- Back -- </a>
            </fieldset> 
        </center>        
    </body>
</html>
