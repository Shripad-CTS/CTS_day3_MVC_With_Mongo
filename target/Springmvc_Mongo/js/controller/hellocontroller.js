app.controller("HelloController", function($scope, $http) {

   $scope.loadHello = function() {
       $http.get("api/employees/hello").then(function(resp){
           $scope.message = resp.data;
       });
   };

});
