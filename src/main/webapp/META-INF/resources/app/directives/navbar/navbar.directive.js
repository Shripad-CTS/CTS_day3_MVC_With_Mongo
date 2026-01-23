angular.module("myApp").directive("appNavbar",function(){
	return{
		restrict:"E",
		templateUrl:"app/directives/navbar/navbar.html",
		controller:"NavController",
		scope: {}, 
	}
})