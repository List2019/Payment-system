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
			<li><a href="/main">Назад</a></li>
			</div>
		</ul>
		</div>
	 	<div class ="main ">
			<ul>
			  <li><a href="admin/allusers">Все пользователи</a></li>
			  <li ><a href="admin/log">Последние транзакции</a></li>
			  <li><a href="/unblocking">Снятие блокировки</a></li>
			</ul>
		</div>
	 </body>
</html>