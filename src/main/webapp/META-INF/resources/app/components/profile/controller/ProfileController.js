angular.module("profileModule").controller("ProfileController",function($scope,$state,AuthService){
	$scope.employee={};
	
	$scope.updateDetails=function(id){
	$state.go("updateDetails", { id: id });
	}
	
	AuthService.getProfile().then(function(res){
		$scope.employee=res;
		console.log($scope.employee)
	}).catch(function(err){
		console.log(err);
	})
});