<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <meta charset="UTF-8">

    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>

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

    <!-- Core App -->
    <script src="app/app.js"></script>
<!--     <script src="app/router/app.router.js"></script> -->

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
    <link rel="stylesheet" href="assets/css/login.css">

    <style>
  .label {
    @apply block text-sm font-semibold text-gray-700 mb-1;
  }
  .input {
    @apply w-full border border-gray-300 rounded px-3 py-2
           focus:outline-none focus:ring-2 focus:ring-blue-500;
  }
</style>
</head>

<body class="bg-gray-100 p-6">

<nav class="flex items-center justify-between mb-6 px-6 py-3 bg-white shadow rounded-lg"
     ng-controller="NavController">

    <!-- Left links -->
    <div class="flex gap-3">
        <a ui-sref="hello" 
           ng-if="isAdmin()"
           class="px-4 py-2 text-sm font-medium text-white bg-blue-600 rounded
                  hover:bg-blue-700 transition">
            Home
        </a>

        <a ui-sref="add"
           ng-if="isAdmin()" 
           class="px-4 py-2 text-sm font-medium text-white bg-green-600 rounded
                  hover:bg-green-700 transition">
            Add Employee
        </a>
    </div>

    <!-- Right actions -->
    <div class="flex gap-3">
        <a ui-sref="login" 
           ng-if="!isLoggedIn()"
           class="px-4 py-2 text-sm font-medium text-white bg-indigo-600 rounded
                  hover:bg-indigo-700 transition">
            Login
        </a>
		
		   <a ui-sref="profile"
           ng-if="isLoggedIn()" 
           class="px-4 py-2 text-sm font-medium text-white bg-green-600 rounded
                  hover:bg-green-700 transition">
            profile
        </a>
		
        <button ng-click="logout()"
                ng-if="isLoggedIn()"
                class="px-4 py-2 text-sm font-medium text-white bg-red-600 rounded
                       hover:bg-red-700 transition">
            Logout
        </button>
    </div>

</nav>


    <hr class="my-4">

    <!-- ui-router outlet -->
    <div ui-view class="p-4 bg-white rounded shadow"></div>

</body>
</html>
