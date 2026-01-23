angular.module("myApp",["ui.router","homeModule","addEmployeeModule","viewEmployeeModule","loginModule","profileModule","changePasswordModule","firstPageModule","updateDetailsModule"])
.config(function($urlRouterProvider){
	$urlRouterProvider.otherwise("/landingpage");
});