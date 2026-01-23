angular.module("updateDetailsModule")
.controller("UpdateDetailsController", function (
    $scope,
    $state,
    AuthService,
    employeeService
) {

    $scope.employee = {};

    // 1. Load logged-in user's profile
    AuthService.getProfile()
        .then(function (res) {
            $scope.employee = angular.copy(res); // safe copy for editing
        })
        .catch(function (err) {
            console.error("Failed to load profile", err);
            $state.go("login");
        });

    // 2. Update user details
    $scope.updateDetails = function () {
        employeeService.updateUserDetails($scope.employee)
            .then(function () {
                alert("Details updated successfully");
                $state.go("profile");
            })
            .catch(function (err) {
                console.error("Update failed", err);
                alert("Error updating details");
            });
    };
	
	$scope.goBack=function(){
		$state.go('profile');
	}

});
