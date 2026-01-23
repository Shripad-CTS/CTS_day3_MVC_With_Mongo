angular.module("viewEmployeeModule").controller("ViewEmployeeController", ViewEmployeeController);

function ViewEmployeeController($scope, $stateParams, $state, employeeService){
	var id= $stateParams.id;
	employeeService.getById(id).then(function(res){
		$scope.employee=res.data;	
	});
	


	$scope.goBack = function () {
	    $state.go("hello");
	};
};