angular.module("addEmployeeModule").controller("AddEmployeeController", AddEmployeeController);

function AddEmployeeController($scope,employeeService){
	$scope.employee={};
	$scope.addEmployee=function(){
		employeeService.create($scope.employee).then(function(){
			                alert("Employee added successfully");
			                $scope.employee = {};
			                $scope.empForm.$setPristine();
			                $scope.empForm.$setUntouched();
		},function(err){
			alert("error"+err);
		});
	}
};