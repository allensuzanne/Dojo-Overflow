<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>New Questions</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
		<h1 class="display-2">What is your Question?</h1>
		
		<form action="/questions/create" method="POST">
		    <p>
		        <label class="col-sm-2 col-form-label">Question:</label>
		        <errors name="question"/>
		        <input class="form-control col-sm-6" name="question"/>
		    </p>
		     <p>
		        <label class="col-sm-2 col-form-label">Tags:</label>
		        <errors name="subject"/>
		        <input class="form-control col-sm-6" name="subject"/>
		    </p>
		    		 
		    <input type="submit" class="btn btn-warning" value="Submit"/>
		</form> 
	</div>


</body>
</html>