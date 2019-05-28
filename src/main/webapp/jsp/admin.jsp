
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello ${adminNick}</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/admin.css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<script src="/js/admin.js"></script>
<script> $(function() { $( "#tabs" ).tabs() }); </script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<h3>Administrator tools</h3>
				<!-- tabs -->
				<div class="tabbable tabs-left">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#faculties" data-toggle="tab">Faculties</a></li>
						<li><a href="#applicants" data-toggle="tab">Applicants</a></li>
						<li><a href="#requests" data-toggle="tab">Requests</a></li>
						<li><a href="#subjects" data-toggle="tab">Subjects</a></li>
						<li><a href="#addNewAdmin" data-toggle="tab">Add new admin</a></li>
						<li><a href="#logout" data-toggle="tab">Logout</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="faculties">
							<div class="table-wrapper">
								<div class="table-title">

									<div class="col-sm-8">
										<h2>
											<b>Faculties</b>
										</h2>
									</div>
									<div class="col-sm-4">
										<button type="button" class="btn btn-info add-new">
											<i class="fa fa-plus"></i> Add New
										</button>
									</div>
									<br>
								</div>
								<form:form method="post" action="/addFaculty"
									modelAttribute="newFaculty">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>Id</th>
												<th>Name</th>
												<th>Places</th>
												<th>Subjects</th>
												<th>Applicants</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${faculties}" var="faculty">
												<tr>
													<td class="faculty_id">${faculty.id}</td>
													<td ><a  class="faculty_name" href="faculty?facultyId=${faculty.id}">${faculty.name}</a></td>
													<td>${faculty.places}</td>
													
													<td><c:forEach items ="${faculty.subjects}" var="subject">${subject.name}; &nbsp</c:forEach></td>
													
													<td>${fn:length(faculty.applicants)}</td>
													<td>
													
															
															 <a class="editf" href="faculty?facultyId=${faculty.id}"
														title="Edit" data-toggle="tooltip"><i
															class="material-icons">&#xE254;</i></a> <a class="delete facultyToDelete"
														title="Delete" data-toggle="tooltip"><i
															class="material-icons">&#xE872;</i></a></td>
												</tr>
											</c:forEach>
											<tr>
												<td></td>
												<td><form:input type="text" class="form-control"
														path="name" name="name" id="name" /></td>
												<td><form:input type="text" class="form-control"
														path="places" name="department" id="department" /></td>
												<%-- <td><form:input type="text" class="form-control"
														path="subjects" name="phone" id="phone" /></td> --%>
												<td><form:select id="uexperience" class="decorated" path="subjects" multiple = "multiple">
                  <option id="selectHeader"> Select subjects</option>
                              <form:options items="${subjects}" itemValue="subjectId" itemLabel="subjectId" />
              
                  </form:select></td>
												<td></td>
												<td>
													<button class="btn_sign_up" type="submit">add</button> <!--                         <input type="submit" value="    add    " /> -->
												</td>
											</tr>
										</tbody>
									</table>
								</form:form>
							</div>
						</div>
						<div class="tab-pane" id="applicants">
							<div class="table-wrapper">
								<div class="table-title">

									<div class="col-sm-8">
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
											<th>Actions</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${applicants}" var="applicant">
											<tr>
												<td class="applicant_id">${applicant.id}</td>
												<td>${applicant.surname}</td>
												<td>${applicant.name}</td>
												<td>${applicant.score}</td>
												<td><a class="add" title="Add" data-toggle="tooltip"><i
														class="material-icons">&#xE03B;</i></a> <a class="edit"
													title="Edit" data-toggle="tooltip"><i
														class="material-icons">&#xE254;</i></a> <a class="delete applicantToDelete"
													title="Delete" data-toggle="tooltip"><i
														class="material-icons">&#xE872;</i></a></td>
											</tr>
										</c:forEach>
										<tr>
									</tbody>
								</table>

							</div>
						</div>

						<div class="tab-pane" id="requests">
						<div class="table-wrapper">
								<div class="table-title">

									<div class="col-sm-8">
										<h2>
											<b>Requests</b>
										</h2>
									</div>
									
									<br>
								</div>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Id</th>
											<th>Faculty</th>
											<th>Applicant</th>
											<th>Status</th>
											<th>Actions</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${requests}" var="request">
											<tr>
												<td class="req_id">${request.id}</td>
												<td title="${request.faculty}">${request.faculty.name}</td>
												<td title="${request.applicant}">${request.applicant.surname}
													${request.applicant.name}</td>
												<td class="status">${request.status}</td>
												<td><a class="approve" title="Approve"
													data-toggle="tooltip"><i class="material-icons" style="color:green">thumb_up</i></a>
																		<a title="Decline" class="decline" data-toggle="tooltip"><i
														class="material-icons" style="color:red">thumb_down</i></a></td>
											</tr>
										</c:forEach>
										<tr>
									</tbody>
								</table>

							</div>
						</div>
						<div class="tab-pane" id="subjects">
							<div class="table-wrapper">
								<div class="table-title">

									<div class="col-sm-8">
										<h2>
											<b>Subjects</b>
										</h2>
									</div>
									<div class="col-sm-4">
										<button type="button" class="btn btn-info add-new">
											<i class="fa fa-plus"></i> Add New
										</button>
									</div>
									<br>
								</div>
								<form:form method="post" action="/addSubject"
									modelAttribute="newSubject">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>Id</th>
												<th>Name</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${subjects}" var="subject">
												<tr>
													<td>${subject.subjectId}</td>
													<td>${subject.name}</td>
													<td><a class="add" title="Add" data-toggle="tooltip"><i
															class="material-icons">&#xE03B;</i></a> <a class="edit"
														title="Edit" data-toggle="tooltip"><i
															class="material-icons">&#xE254;</i></a> <a class="delete"
														title="Delete" data-toggle="tooltip"><i
															class="material-icons">&#xE872;</i></a></td>
												</tr>
											</c:forEach>
											<tr>
												<td></td>
												<td><form:input type="text" class="form-control"
														path="name" name="name" id="name" /></td>
																			
												<td>
													<button class="btn_sign_up" type="submit">add</button> <!--                         <input type="submit" value="    add    " /> -->
												</td>
											</tr>
										</tbody>
									</table>
								</form:form>
							</div>
						</div>
						

						<div class="tab-pane" id="addNewAdmin">
							<div class="table-wrapper">
								<h1>You can add new addmin here</h1>
									<form:form method="post" action="/addAdmin"
									modelAttribute="newAdmin">
								
									<label for="fname">NickName</label> 
									<form:input type="text" class="formAddAdmin"
										id="fname" path="nickName" placeholder="NickName"/>

									<label for="lname">Password</label> 
									<form:input type="password" class="formAddAdmin"
										id="lname" path="password" placeholder="Password"/>
									<button class="addAdminButton" type="submit">Add Admin</button>
																</form:form>
							</div>
						</div>
						<div class="tab-pane" id="logout">
							<div class="">
								<h1>Do you realy want to leave admin tools?</h1>
							 <a href="<c:url value="/logout" />" class="exitButton">exit</a>
							</div>
						</div>
					</div>
				</div>
				<!-- /tabs -->
			</div>
		</div>

	</div>
</body>
</html>