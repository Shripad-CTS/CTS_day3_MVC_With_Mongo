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

    <!-- Core App -->
    <script src="app/app.js"></script>
    <script src="app/router/app.router.js"></script>

    <!-- Services -->
    <script src="app/services/employee.service.js"></script>

    <!-- Controllers -->
    <script src="app/components/home/controller/HomeController.js"></script>
    <script src="app/components/addEmployee/controller/AddEmployeeController.js"></script>
    <script src="app/components/viewEmployee/controller/ViewEmployeeController.js"></script>
    
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

    <nav class="flex gap-4 mb-4">
        <a ui-sref="hello"
           class="px-4 py-2 bg-blue-500 text-white rounded">
           Hello
        </a>

        <a ui-sref="add"
           class="px-4 py-2 bg-green-500 text-white rounded">
           Add
        </a>
    </nav>

    <hr class="my-4">

    <!-- ui-router outlet -->
    <div ui-view class="p-4 bg-white rounded shadow"></div>

</body>
</html>
