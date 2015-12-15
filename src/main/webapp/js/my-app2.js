var myApp = new Framework7();

// Export selectors engine
var $$ = Dom7;

$$("#toLogin").click(function(){
	$$("#loginForm").submit();
})