angular.module("myApp").factory("AuthInterceptor", function() {
    return {
        request: function(config) {
            const token = localStorage.getItem("token");
            if (token) config.headers["Authorization"] = "Bearer " + token;
            return config;
        }
    };
});

angular.module("myApp").config(function($httpProvider){
    $httpProvider.interceptors.push("AuthInterceptor");
});
