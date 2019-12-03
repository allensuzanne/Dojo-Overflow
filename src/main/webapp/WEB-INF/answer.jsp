<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Answers</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
		<h1 class="display-2"><c:out value="${question.question}"/></h1>
		<h5>Tags: <c:forEach var="subject" items="${question.taggings}"> <c:out value="${subject.subject}"/> </c:forEach></h5>
		<div class="row">
			<table class="table table-striped section_one">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">Answers</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="answer" items="${answers}" >
			    <tr>
			      <td><c:out value="${answer.answer}"/></td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			<div class="section_two"></div>
			<h5>Add your Answer:</h5>
			<div></div>
			<form action="/questions/${question.id}/answer" method="POST" >
			<p>				
		        <label class="col-md-6 col-form-label" >Answer:</label>
		        <input class="form-control col-md-6" name="answer"/> 
		       </p>	
		    <input type="submit" class="btn btn-warning" value="Answer It!"/>
		</form>
		</div> 
	</div>

</body>
</html>