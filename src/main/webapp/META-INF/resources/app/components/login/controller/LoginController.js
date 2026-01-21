angular.module("loginModule").controller("LoginController", function ($scope,AuthService,$state) {

    $scope.loginData = {
        email: "",
        password: ""
    };

    $scope.login = function () {
        AuthService.login($scope.loginData)
            .then(function () {
                // Login success
               $state.go("hello");
			   console.log("login sucess")
            })
            .catch(function (err) {
                $scope.error = "Invalid email or password";
				console.log(err);
            });
    };
	
	$scope.logout=function(){
		AuthService.logout().then(function(){
			$state.go("login");
			console.log("logout sucuss");
		}).catch(function(err){
			console.log(err);
		})
	}
});
