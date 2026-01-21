angular.module("homeModule").controller("HomeController", HomeController);

function HomeController($scope, employeeService, $state) {
	$scope.employees=[];
	
	$scope.page = 0;
	$scope.size = 10;
	$scope.sortBy = 'name';
	$scope.sortDir = 'asc';

	$scope.search = '';
	$scope.department = '';
	$scope.role = '';

	$scope.sort = function (column) {
	    if ($scope.sortBy === column) {
	        $scope.sortDir = $scope.sortDir === 'asc' ? 'desc' : 'asc';
	    } else {
	        $scope.sortBy = column;
	        $scope.sortDir = 'asc';
	    }
	    $scope.page = 0;
	    $scope.loadEmployee();
	};
	
	$scope.loadEmployee = function() {
		var params={		page:$scope.page,
		size:$scope.size ,
		sortBy:$scope.sortBy,
		sortDir:$scope.sortDir,

		search:$scope.search,
		department:$scope.department,
		role:$scope.role};
		employeeService.search(params).then(function(res) {
			$scope.employees = res.data.content;
			$scope.totalPages=res.data.totalPages;
			$scope.totalElements=res.data.totalElements;
		}, function(err) {
			console.log(err);
		});
	}
	
	$scope.viewEmployee = function (id) {
	     $state.go("view", { id: id });
	 };
	 
	 $scope.updateEmployee=function(id){
		$state.go("update",{id:id});
	 }
	 
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
	 $scope.loadEmployee();
};