angular.module("myApp").config(function($stateProvider, $urlRouterProvider){

	$urlRouterProvider.otherwise("/login");
  $stateProvider
    .state("hello", {
        url: "/hello",
        templateUrl: "app/components/home/partials/home.html",
        controller: "HomeController"
    })
	.state("add", {
	        url: "/add",
	        templateUrl: "app/components/addEmployee/partials/add-employee.html",
	        controller: "AddEmployeeController"
	    })
		.state("view", {
		        url: "/view/:id",
		        templateUrl: "app/components/viewEmployee/partials/view-employee.html",
		        controller: "ViewEmployeeController"
		    }).state("update",{
				url:"/update/:id",
				templateUrl:"app/components/addEmployee/partials/add-employee.html",
				controller:"AddEmployeeController"
				
			}).state("login",{
				url:"/login",
				templateUrl:"app/components/login/partials/login.html",
				controller:"LoginController"
			});
});
