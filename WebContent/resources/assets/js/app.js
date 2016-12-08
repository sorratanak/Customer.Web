var app = angular.module('Application', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise('/');
	$stateProvider
	.state('customer',{
		url:'/',
		templateUrl:'resources/views/customer.html',
		controller:'customerCtrl',
		controllerAs:'/customer'
	})
	
})