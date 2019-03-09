<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
 <head>
 <meta charset="utf-8" />
 <title>Регистрация</title>
  <style>
     <%@include file="/WEB-INF/css/main.css"%>
 </style>
<!--  <script src="/WEB-INF/script/jquery-3.3.1.min.js"></script> -->
 <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
  	<script type="text/javascript">
    <%@include file="/WEB-INF/script/registration.js"%>
</script>
 </head>
	 <body>
	 	<div class = "form">
	 	<c:if test="${errors != null}">
            <div class="errorMessage">
            <div style="font-weight: 600;">
            Не удается зарегистрироваться<br>
            <br>
          </div>

           <c:forEach var="error" items="${errors}">
           	${error.defaultMessage}<br>
         </c:forEach>
           </div>
        </c:if>
		 <form method="post" action="/registration">
		 	 <input name="name" type="text" placeholder="Имя"required autofocus/>
		 	 <input name="last_name" type="text" placeholder="Фамилия"required/>
     		 <input name="password" type="password" placeholder="Пароль"required/>
     		 <input name="number_card" type="number" placeholder="Номер карты"required/>
     		 <input id="login" name="login" type="text" placeholder="Логин"required/>
     		 <input name="email" type="text" placeholder="Электронная почта"required/>
       		 <form action="">
    		 <button type="submit">Регистрация</button>
			 </form>
		</div>
		</form>
	 </body>
</html>