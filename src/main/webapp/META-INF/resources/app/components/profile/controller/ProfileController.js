angular.module("profileModule").controller("ProfileController",function($scope,AuthService){
	$scope.employee={};
	
	AuthService.getProfile().then(function(res){
		$scope.employee=res;
		console.log($scope.employee)
	}).catch(function(err){
		console.log(err);
	})
});