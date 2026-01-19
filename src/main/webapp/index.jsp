<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>

<script src="app/components/home/home.module.js"></script>

<!-- Main App -->
<script src="app/app.js"></script>

<!-- Controller & Service -->
<script src="app/components/home/controller/HomeController.js"></script>
  
</head>

<body ng-controller="HomeController">

    <div ng-include="'app/components/home/partials/home.html'"></div>

</body>
</html>
