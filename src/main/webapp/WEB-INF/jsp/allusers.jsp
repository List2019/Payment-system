<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
 <head>
 <meta charset="utf-8" />
 <title>Администрирование</title>
 <style>
     <%@include file="/WEB-INF/css/main.css"%>
 </style>
 </head>
	 <body>
	 	<div class="button">
		<ul>
			<div class="logout">
			<li><a href="/logout">выйти</a></li>
			</div>
			<div class="back">
			<li><a href="/admin">Назад</a></li>
			</div>
		</ul>
		</div>
	 	<table>
	 	<tr>
				  <th>id_users</th>
				  <th>name</th>
				  <th>last_name</th>
				  <th>number_card</th>
				  <th>password</th>
				  <th>login</th>
				  <th>role</th>
				  <th>email</th>
				</tr>
	 	<c:forEach var="userIterator" items="${users}">
			<tr>
					<td><a>${userIterator.getId_users()}</a></td>
					<td><a>${userIterator.getName()}</a></td>
					<td><a>${userIterator.getLast_name()}</a></td>
					<td><a>${userIterator.getNumber_card()}</a></td>
					<td><a>${userIterator.getPassword()}</a></td>
					<td><a>${userIterator.getLogin()}</a></td>
					<td><a>${userIterator.getRole()}</a></td>
					<td><a>${userIterator.getEmail()}</a></td>
					<br>
				</tr>
		</c:forEach>

		<!-- href="/book/${userIterator.Id_users}" -->
		</table>
	 </body>
</html>