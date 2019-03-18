<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
 <head>
 <meta charset="utf-8" />
 <title>Последние операции</title>
 <style>
     <%@include file="/WEB-INF/css/main.css"%>
 </style>
  <script src="/WEB-INF/script/jquery-3.3.1.min.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
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
			
			</tr>
		</c:forEach>
		</table>
	 </body>
</html>