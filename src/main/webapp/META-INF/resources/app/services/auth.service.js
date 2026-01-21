angular.module("myApp")
.service("AuthService", function ($http) {

    this.login = function (data) {
		console.log(data);
        return $http({
            method: "POST",
            url: "/Springmvc_Mongo/auth/login",
            data: "email=" + encodeURIComponent(data.email) +
                  "&password=" + encodeURIComponent(data.password),
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            }
        });
    };

    this.logout = function () {
        return $http.post("/Springmvc_Mongo/auth/logout");
    };
});
