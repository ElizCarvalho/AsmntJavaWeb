<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/recursos/css/main.css" />" rel="stylesheet">
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
        <title>Library - Login</title>  
    </head>
    <body>
        <center>
            <fieldset>
                <h2>LOGIN</h2>
                </br>
                <div class="campo">
                    <label for="text"><c:out value="${message}"/></label>
                </div>
        
                <s:form action="singIn.htm" modelAttribute="user" method="POST">
                    <table>
                        <tr>
                            <div class="campo">
                                <td><label for="username">Username: </label></td>
                                <td><s:input path="username"  size="35em"/></td>
                            </div>
                        </tr>
                        <tr>
                            <div class="campo">
                                <td><label for="password">Password: </label></td>
                                <td><s:password path="password"  size="35em"/></td>
                            </div>
                        </tr>
                    </table>
                    <br/>
                    <button class="botao submit" type="submit" name="login">Login</button>   
                </s:form>
                <br/><br/>
                <a href="startRegisterUser.htm"> -- User Register -- </a>
        
            </fieldset>
        </center>
    </body>
</html>
