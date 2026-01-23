angular.module("changePasswordModule")
.controller("ChangePasswordController", function ($scope, $state, AuthService) {

    $scope.passwordData = {
        newPassword: ""
    };

    $scope.changePassword = function () {
        AuthService.changePassword($scope.passwordData)
            .then(function () {
                alert("Password updated successfully");
				console.log("sucess")
                $state.go("hello");
            })
            .catch(function (err) {
                console.log(err)
            });
    };
});
