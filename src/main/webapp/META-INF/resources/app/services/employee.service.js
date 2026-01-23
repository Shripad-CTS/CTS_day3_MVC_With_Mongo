angular.module("myApp").service("employeeService",function($http){
	var baseUrl="http://localhost:8080/Springmvc_Mongo/api";
	
	this.getAll=function(){
		return $http.get(baseUrl+"/admin/getAllEmployee");
	}
	
	this.getById=function(id){
		return $http.get(baseUrl+"/admin/getEmployee/"+id)
	}
	
	this.create=function(employee){
		return $http.post(baseUrl+"/admin/addEmployee",employee) 
	}
	
	this.updateById=function(id,employee){
		return $http.put(baseUrl+"/admin/updateEmployee/"+id,employee)
	}
	this.delete=function(id){
		return $http.delete(baseUrl+"/admin/deleteEmployee/"+id)
	}
	
	this.search=function(params){
		return $http.get(baseUrl+"/admin/searchEmployee",{params:params},{  withCredentials: true })
	}
	
	this.updateUserDetails = function (employee) {
	    return $http.put(baseUrl + "/user/update-details", employee);
	};

});