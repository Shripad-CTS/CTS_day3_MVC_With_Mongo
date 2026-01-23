angular.module("myApp")
.service("AuthService", function ($http) {
 var loggedIn=false;
 var role = null;
 this.login = function (data) {
     return $http.post("/Springmvc_Mongo/auth/login", data)
         .then(function(res){
             localStorage.setItem("token", res.data.token);
             role = res.data.role;
             loggedIn = true;
             return res.data;
         });
 };

 this.logout = function () {
     localStorage.removeItem("token");
     loggedIn = false;
     role = null;
 };
	
	this.isLoggedIn = function(){
		return loggedIn;
	}
	
	

	this.getProfile = function(){
	    return $http.get("/Springmvc_Mongo/auth/profile", {
	        headers: { "Authorization": "Bearer " + localStorage.getItem("token") }
	    }).then(function(res){
	        role = res.data.role;
	        return res.data;
	    });
	};
	
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
	
	this.changePassword = function (data) {
	    return $http.post("/Springmvc_Mongo/auth/change-password", data);
	};


});
