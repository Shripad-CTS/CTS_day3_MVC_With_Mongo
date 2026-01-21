angular.module("myApp").service("employeeService",function($http){
	var baseUrl="http://localhost:8080/Springmvc_Mongo/api";
	
	this.getAll=function(){
		return $http.get(baseUrl+"/getAllEmployee");
	}
	
	this.getById=function(id){
		return $http.get(baseUrl+"/getEmployee/"+id)
	}
	
	this.create=function(employee){
		return $http.post(baseUrl+"/addEmployee",employee) 
	}
	
	this.updateById=function(id,employee){
		return $http.put(baseUrl+"/updateEmployee/"+id,employee)
	}
	this.delete=function(id){
		return $http.delete(baseUrl+"/deleteEmployee/"+id)
	}
	
	this.search=function(params){
		return $http.get(baseUrl+"/searchEmployee",{params:params},{  withCredentials: true })
	}
	
});