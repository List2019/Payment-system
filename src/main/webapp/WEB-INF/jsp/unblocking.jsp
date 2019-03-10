<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
 <head>
 <meta charset="utf-8" />
 <title>Снятие блокировки</title>
 <style>
     <%@include file="/WEB-INF/css/main.css"%>
 </style>
 <script src="/WEB-INF/script/jquery-3.3.1.min.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
 </head>
	 <body>  
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
					<td><input type="checkbox" name="id_users" value=${userIterator.getId_users()}><br></td>
				</tr>
				</c:forEach>
			</table>
	
		<div class="unblock">
		<form method="post" action="/unblocking">
	    <input name="number_card" type="number" placeholder="Номер карты" required/>

	    <form action="">
	    	<button type="submit">Разблокировать</button>
		</form>	

		</form>	
		</div>
		${message}
	 </body>
</html>