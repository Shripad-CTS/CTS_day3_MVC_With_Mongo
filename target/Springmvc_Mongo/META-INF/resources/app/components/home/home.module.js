angular.module("homeModule",["ui.router"])
.constant("HOME_PATH","app/components/home")
.config(function($stateProvider,HOME_PATH){
	$stateProvider
	.state("hello",{
		url:"/hello",
		templateUrl:HOME_PATH+"/partials/home.html",
		controller:"HomeController"
	})
	
});