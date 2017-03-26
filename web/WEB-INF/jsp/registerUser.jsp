<%-- 
    Document   : login
    Created on : 26/03/2017, 12:10:04
    Author     : Eliz
--%>

<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>	
        <title>User Registration</title>	
        <link href="style.css" rel="stylesheet" type="text/css">
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
            <h2>User Registration</h2>

            <s:form method="post" modelAttribute="user" action="cadastrarUser.htm">
            
                <table>
                    <tr>
                        <div class="campo">
                            <td><label for="username">Username: </label></td>
                            <td><s:input path="username" size="35em"/> </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="campo">
                            <td><label for="password">Password: </label></td>
                            <td><s:password path="password" size="35em"/></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="campo">
                            <td><label for="email">Email: </label></td>
                            <td><s:input path="email" size="35em"/></td>
                        </div
                    </tr>
                    
                </table>
                    
                <button class="botao submit" type="submit" name="submit">Register</button>
                <button class="botao submit" type="reset" name="reset">Reset</button>
                    
            </s:form>

            <br/>
            <a href="login.htm"> -- Back --</a>
        </fieldset>
    </center>
    </body>

</html>
