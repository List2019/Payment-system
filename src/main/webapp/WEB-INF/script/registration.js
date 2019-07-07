$('document').ready(function(){
   $("#login").keyup(function(){
     $.ajax({
     	type: "GET",
     	url: '/checkLoginExist',
     	data:{'login':$("#login").val()
        }  
        }).done(function (msg) {
     	if(msg == true){
     		$("#login").css("background-color","green");
     	}
     	else {
     		$("#login").css("background-color","red");
     	}
   });
});
});




