<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">

    <!-- AngularJS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>

    <!-- UI-Router -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/1.0.30/angular-ui-router.min.js"></script>


    <!-- App Modules -->
    <script src="app/components/home/home.module.js"></script>
    <script src="app/components/addEmployee/addemployee.module.js"></script>
    <script src="app/components/viewEmployee/viewemployee.module.js"></script>
    <script src="app/components/login/login.module.js"></script>
    <script src="app/components/profile/profile.module.js"></script>
    <script src="app/components/changePassword/changepassword.module.js"></script>
    <script src="app/components/firstPage/firstpage.module.js"></script>
    <script src="app/components/updateDetails/updatedetails.module.js"></script>
    
      
    <!-- Core App -->
    <script src="app/app.js"></script>
	
	<script src="app/services/AuthInterceptor.js"></script>
      <script src="app/directives/navbar/navbar.directive.js"></script>
    <!-- Services -->
    <script src="app/services/employee.service.js"></script>
    <script src="app/services/auth.service.js"></script>

    <!-- Controllers -->
    <script src="app/components/login/controller/LoginController.js"></script>
    <script src="app/components/home/controller/NavController.js"></script>
    <script src="app/components/home/controller/HomeController.js"></script>
    <script src="app/components/addEmployee/controller/AddEmployeeController.js"></script>
    <script src="app/components/viewEmployee/controller/ViewEmployeeController.js"></script>
    <script src="app/components/profile/controller/ProfileController.js"></script>
    <script src="app/components/changePassword/controller/ChangePasswordController.js"></script>
    <script src="app/components/firstPage/controller/FirstPageController.js"></script>
        <script src="app/components/updateDetails/controller/UpdateDetailsController.js"></script>

    
    <link rel="stylesheet" href="assets/css/login.css">

</head>

<body class="bg-gray-100 p-6">



<app-navbar></app-navbar>

    <hr class="my-4">

    <div ui-view class="p-4 bg-white rounded shadow"></div>

</body>
</html>