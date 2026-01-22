angular.module("myApp",["ui.router","homeModule","addEmployeeModule","viewEmployeeModule","loginModule","profileModule"])
.config(function($urlRouterProvider){
	$urlRouterProvider.otherwise("/login");
}).run(function(AuthService) {
    AuthService.restoreSession();
});;