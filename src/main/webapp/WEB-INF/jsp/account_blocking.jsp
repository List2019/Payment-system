<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
 <head>
 <meta charset="utf-8" />
 <title>Блокировка счёта</title>
 <style>
     <%@include file="/WEB-INF/css/main.css"%>
 </style>
<!-- <script src="/WEB-INF/script/jquery-3.3.1.min.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
  <script type="text/javascript">
    <%@include file="../script/blocking.js"%>
</script> -->
 </head>
	 <body>
	 	<div class="logout">
		<ul><li><a href="/logout">выйти</a></li></ul>
		</div>
	 	<div class="form">
		 <form method="post" action="/account_blocking">
		   <textarea cols="40" rows="5" autofocus maxlength="1000" placeholder="Напишите причину сюда" required></textarea></p>
			<form action="">
    		 <button>Заблокировать</button>
			</form>
		 </form>
		</div>
		<div id="message">
	    ${message}
		</div>
	</body>
</html>