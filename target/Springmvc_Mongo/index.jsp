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

    <style>
        * {
            font-family: 'Inter', sans-serif;
        }
        
        .gradient-bg {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        }
        
        .gradient-text {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
        }
        
        .glass-effect {
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
        }
        
        .card-hover {
            transition: all 0.3s ease;
        }
        
        .card-hover:hover {
            transform: translateY(-5px);
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
        }
        
        .btn-primary {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            transition: all 0.3s ease;
        }
        
        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(102, 126, 234, 0.3);
        }
        
        .btn-secondary {
            background: linear-gradient(135deg, #4CAF50 0%, #45a049 100%);
            color: white;
            transition: all 0.3s ease;
        }
        
        .btn-secondary:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(76, 175, 80, 0.3);
        }
        
        .btn-danger {
            background: linear-gradient(135deg, #f44336 0%, #d32f2f 100%);
            color: white;
            transition: all 0.3s ease;
        }
        
        .btn-danger:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(244, 67, 54, 0.3);
        }
        
        .nav-link {
            position: relative;
            overflow: hidden;
            transition: all 0.3s ease;
        }
        
        .nav-link::after {
            content: '';
            position: absolute;
            bottom: 0;
            left: 0;
            width: 0;
            height: 2px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            transition: width 0.3s ease;
        }
        
        .nav-link:hover::after {
            width: 100%;
        }
        
        .label {
            @apply block text-sm font-semibold text-gray-700 mb-2;
        }
        
        .input {
            @apply w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-purple-500 focus:border-transparent transition-all duration-300;
        }
        
        .animate-slide-up {
            animation: slideUp 0.5s ease-out;
        }
        
        @keyframes slideUp {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
        
        .pulse-ring {
            animation: pulse 2s infinite;
        }
        
        @keyframes pulse {
            0% {
                box-shadow: 0 0 0 0 rgba(102, 126, 234, 0.7);
            }
            70% {
                box-shadow: 0 0 0 10px rgba(102, 126, 234, 0);
            }
            100% {
                box-shadow: 0 0 0 0 rgba(102, 126, 234, 0);
            }
        }
    </style>
</head>

<body class="bg-gray-100 p-6">

<!-- <nav class="flex items-center justify-between mb-6 px-6 py-3 bg-white shadow rounded-lg"
     ng-controller="NavController">

    Left links
    <div class="flex gap-3">
       <a ui-sref="firstPage" 

           class="px-4 py-2 text-sm font-medium text-white bg-blue-600 rounded
                  hover:bg-blue-700 transition">
           Home
        </a>
    
        <a ui-sref="hello" 
           ng-if="isAdmin()"
           class="px-4 py-2 text-sm font-medium text-white bg-blue-600 rounded
                  hover:bg-blue-700 transition">
            Employee Actions
        </a>

        <a ui-sref="add"
           ng-if="isAdmin()" 
           class="px-4 py-2 text-sm font-medium text-white bg-green-600 rounded
                  hover:bg-green-700 transition">
            Add Employee
        </a>
    </div>

    Right actions
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

</nav> -->

<app-navbar></app-navbar>

    <hr class="my-4">

    <!-- ui-router outlet -->
    <div ui-view class="p-4 bg-white rounded shadow"></div>

</body>
</html>