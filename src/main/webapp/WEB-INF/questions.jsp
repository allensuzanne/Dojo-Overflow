<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Questions</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
		<h1 class="display-2">Questions Dashboard</h1> 
		
		<table class="table table-striped">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">Questions</th>
		      <th scope="col">Tags</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="question" items="${questions}" >
		    <tr>
		      <td><a href="/questions/${question.id}"<c:out value="${question.id}"/>"><c:out value="${question.question}"/></a></td>
		      <td><c:forEach var="subject" items="${question.taggings}"><c:out value="${subject.subject}"/></c:forEach></td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<a href = "questions/new">New Question</a>
	</div>

</body>
</html>