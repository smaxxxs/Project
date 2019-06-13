<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/admin.css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
	<link rel="stylesheet" href="/css/faculty.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/faculty.js"></script>
<title>${faculty.name}</title>
</head>
<body>
<div class="row">
<div class="col-sm-4">
<h3>${faculty.name}</h3>
<h3> <b> free places: </b> ${faculty.places}</h3>
<h3> <b> applicants at this moment: </b> ${fn:length(faculty.applicants)}</h3>
<h3><b>Subjects: </b><c:forEach items ="${faculty.subjects}" var="subject">${subject.name}; &nbsp</c:forEach></h3>
<h3><b>Grade:</b>${faculty.grade}</h3>
</div>

<div class="col-sm-8">
<button class="editButton">Edit</button>
<div class="editForm invisible">
<form:form method="post" action="/editFaculty"
									modelAttribute="thisFaculty">
									<form:input type="hidden" path="id" value="${faculty.id}"/>
									Faculty name: <form:input type="text" class="form-control"
														path="name" value="${faculty.name}" />
												Places: <form:input type="number" class="form-control"
														path="places" value="${faculty.places}"/>
												<form:checkboxes items="${subjects}"  itemValue="subjectId" itemLabel="name"  path="subjects" />
												<br>
                          <button class="saveButton" type="submit">Save changes</button>
								</form:form>
</div>
</div>

<a href="/admin" class="back">Back</a>

</div>
<div class="row">
<div class="table-wrapper">
								<div class="table-title">

									<div class="col-md-6">
										<h2>
											<b>Applicants</b>
										</h2>
									</div>
								<br>
								</div>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Id</th>
											<th>Surname</th>
											<th>Name</th>
											<th>Score</th>
											
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${faculty.applicants}" var="applicant">
											<tr>
												<td class="applicant_id">${applicant.id}</td>
												<td>${applicant.surname}</td>
												<td>${applicant.name}</td>
												<td>${applicant.score}</td>
												
											</tr>
										</c:forEach>
										<tr>
									</tbody>
								</table>

							</div>
							</div>
</body>
</html>