angular.module("addEmployeeModule").controller("AddEmployeeController", AddEmployeeController);

function AddEmployeeController($scope,$stateParams, employeeService,$state){
	$scope.employee={};
	$scope.isEdit=false;
	if($stateParams.id){
		$scope.isEdit=true;
		employeeService.getById($stateParams.id).then(function(res){
			$scope.employee=res.data;
		})
	}
	$scope.submitEmployee=function(){
		if($scope.isEdit){
			employeeService.updateById($scope.employee.id,$scope.employee).then(function(){
				alert("employee updated successfully");
				$scope.employee={};
				$scope.empForm.$setPristine();
				$scope.empForm.$setUntouched();
				$state.go("hello");
			},function(){
				alert("error");
			})
		}else{
			employeeService.create($scope.employee).then(function(){
						                alert("Employee added successfully");
						                $scope.employee = {};
						                $scope.empForm.$setPristine();
						                $scope.empForm.$setUntouched();
										$state.go("hello");
					},function(err){
						alert("error"+err);
					});
		}
	}
};