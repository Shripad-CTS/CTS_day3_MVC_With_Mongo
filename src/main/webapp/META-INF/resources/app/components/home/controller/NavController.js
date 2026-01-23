angular.module("myApp").controller("NavController", NavController);

function NavController($scope,$state,AuthService){
	$scope.isLoggedIn=AuthService.isLoggedIn;
	$scope.isAdmin = AuthService.isAdmin;
	$scope.isUser = AuthService.isUser;

	// Load profile on refresh

	
	$scope.logout=function(){
		AuthService.logout();
		 $state.go("login");
	}
	if (AuthService.isLoggedIn()) {
	    AuthService.getProfile();
	}

}