<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html >
<html data-ng-app="Application" data-ng-controller="mainCtrl as main">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>{{Page.title()}}</title>
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/css/bootstrap.min.css"/>">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/css/sweetalert.css"/>">
    
	
	<script src="<c:url value="/resources/assets/jquery/jquery-3.1.0.min.js"/>"></script>
	<script src="<c:url value="/resources/assets/jquery/bootstrap.min.js"/>"></script>
	
	
	
	
	<script src="<c:url value="/resources/assets/js/lib/angular.min.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/lib/angular-ui-router.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/lib/angular-jwt.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/lib/angular-storage.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/lib/angular-touch.min.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/lib/angular-animate.min.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/lib/ui-bootstrap-tpls-2.1.3.min.js"/>"></script>
	
	<script src="<c:url value="/resources/assets/js/lib/ng-table.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/lib/sweetalert.min.js"/>"></script>
	
	<script src="<c:url value="/resources/assets/js/app.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/controllers.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/services.js"/>"></script>
	
	
	
</head>
<body>
	<div data-ui-view></div>
	
</body>

</html>