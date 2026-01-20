angular.module("homeModule").controller("HomeController", HomeController);

function HomeController($scope, employeeService,$state) {
	$scope.title = "hello";
	$scope.employees=[];
	$scope.change = function() {
		$scope.title = "button clicked";
	};
	$scope.loadEmployee = function() {
		employeeService.getAll().then(function(res) {
			$scope.employees = res.data;
		}, function(err) {
			$scope.title = err;
		});
	}
	
	$scope.viewEmployee = function (id) {
	     $state.go("view", { id: id });
	 };
	 
	 $scope.deleteEmployee=function(id){

		if (!id) {
		    alert("Invalid employee id");
		    return;
		}

		if (confirm("Are you sure you want to delete this employee?")) {
		    employeeService.delete(id).then(function () {
		        alert("Employee deleted successfully");
		        $scope.loadEmployee(); 
		    });
		}
	 }
};