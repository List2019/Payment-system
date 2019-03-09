<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
 <head>
 <meta charset="utf-8" />
 <title>Логи</title>
 <style>
     <%@include file="/WEB-INF/css/main.css"%>
 </style>
 </head>
	 <body>
	 	<table>
	 	<tr>
				  <th>id_transaction</th>
				  <th>id_users</th>
				  <th>time_transaction</th>
				  <th>new_balance</th>
				</tr>
	 	<c:forEach var="logIterator" items="${logs}">
			<tr>
					<td><a>${logIterator.getId_transaction()}</a></td>
					<td><a>${logIterator.getId_users()}</a></td>
					<td><a>${logIterator.getTime_transaction()}</a></td>
					<td><a>${logIterator.getNew_balance()}</a></td>
					<br>
				</tr>
		</c:forEach>

		<!-- href="/book/${userIterator.Id_users}" -->
		</table>
	 </body>
</html>