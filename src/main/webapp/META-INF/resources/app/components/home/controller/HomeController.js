angular.module("homeModule").controller("HomeController", HomeController);

function HomeController($scope, $http) {
	$scope.title = "hello";
	$scope.employees=[];
	$scope.change = function() {
		$scope.title = "button clicked";
	};
	$scope.loadEmployee = function() {
		$http.get("/Springmvc_Mongo/api/hello").then(function(res) {
			$scope.employees = res.data;
		}, function(err) {
			$scope.title = err;
		});
	}
};