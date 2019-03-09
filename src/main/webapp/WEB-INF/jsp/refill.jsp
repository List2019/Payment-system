<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
 <head>
 <meta charset="utf-8" />
 <title>Пополнение</title>
 <style>
     <%@include file="/WEB-INF/css/main.css"%>
 </style>
 </head>
	 <body>
	 	<div class="logout">
		<ul><li><a href="/logout">выйти</a></li></ul>
		</div>
	 	<div class = "form">
		 <form method="post" action="/refill">
         <input name="value" type="number" required placeholder="Сумма">
			<form action="#">
    		 <button type="submit">Пополнить</button>
			 </form>
		</form>
	    </div>
	    ${message}
	 </body>
</html>