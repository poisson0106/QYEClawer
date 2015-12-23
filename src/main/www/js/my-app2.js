var myApp = new Framework7();

 // Export selectors engine
var $$ = Dom7;

var mainView = myApp.addView('.view-main', {
    // Because we use fixed-through navbar we can enable dynamic navbar
    dynamicNavbar: true
});

$$("#toLogin").click(function(){
	/*$$.ajax({
		url : 'http://9.123.200.73:8080/bookcapture/loginOneUser',
		method : 'POST',
		data : {
			username : $$("#username").val(),
			password : $$("#password").val()
		},
		dataType : "json",
		success : function(data, status, xhr){
			var url = data.targetUrl;
			alert(url);
			window.location.href = url
		},
		error : function (xhr, status){
			alert(status);
		}
	});*/
	mainView.router.loadPage('index2.html');
})