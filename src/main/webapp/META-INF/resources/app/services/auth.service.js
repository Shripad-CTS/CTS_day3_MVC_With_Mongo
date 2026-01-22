angular.module("myApp")
.service("AuthService", function ($http) {
 var loggedIn=false;
 var role = null;
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
        }).then(function(res){
			console.log(res);
		loggedIn=true;
		return res;
		});
    };

    this.logout = function () {
        return $http.post("/Springmvc_Mongo/auth/logout").then(function(){
			loggedIn=false;
			role = null;
		});
    };
	
	this.isLoggedIn = function(){
		return loggedIn;
	}
	
	
	this.getProfile= function(){
		return $http.get("/Springmvc_Mongo/auth/profile").then(function (res) {
		                role = res.data.role;  
		                return res.data;
		            });
	}
	
	this.isAdmin=function(){
		return role==="ADMIN"
	}
	this.isUser=function(){
		return role==="USER"
	}
	
	this.restoreSession = function () {
	    return $http.get("/Springmvc_Mongo/auth/profile")
	        .then(function (res) {
	            loggedIn = true;
	            role = res.data.role;
	            return res.data;
	        })
	        .catch(function () {
	            loggedIn = false;
	            role = null;
	        });
	};

});
