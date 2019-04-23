<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
 <head>
 <meta charset="utf-8" />
 <title>Снятие блокировки</title>
 <style>
     <%@include file="/WEB-INF/css/main.css"%>
 </style>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
 </head>
	 <body>  
	 	<form:form method="POST" modelAttribute="Credit_card" action="/unblocking">
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
		<br><br>
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
				  <th></th>
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
					<td><form:checkbox path="number_card" value="${userIterator.getNumber_card()}" />
						<br></td>
				</tr>
				</c:forEach>
			</table>

	   	<div class="form">
	    <form  action="">
	    	<button type="submit">Разблокировать</button>
		</form>	
		</div>
		</form:form>
		</div>
		${message} 
	 </body>
</html>