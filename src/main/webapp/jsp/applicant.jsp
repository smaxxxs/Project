<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to cabinet ${applicant.nickName}</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/applicant.css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="/js/applicant.js"></script>

</head>
<body>
<a href="<c:url value="/logout" />"><input class="button4" type="button" value="LogOut"/></a>
  <div class="container">
  <div class="row">
  <div class="col-lg-6">
  <div class ="appInfo"> 
  <h5>Surname: ${applicant.surname}</h5>
  <h5>Name: ${applicant.name}</h5>
  <h5>My nickName: ${applicant.nickName}</h5>
  <h5>MyScore: ${applicant.score}</h5>
  
  </div>
  <div class="card" style="width: 18rem;">
  <div class="img_wraper">
  <img  src="/photos/${applicant.nickName}.jpg">
  </div>
  <div class="card-body">
    
    <form:form method="POST" action="uploadFile" enctype="multipart/form-data">
   
            <h4>Select photo to upload</h4>
       <input class = "photo_up" type="file" name="photo" />
       <input class= "submit_photo" type="submit" value="Submit" />
            
       
</form:form>
  </div>
  
</div>
  </div>
  </div>
    <div class="row">
      <div class="col-lg-6">
      <h3> ${applicant.name}, you can add here your subject points </h3>
				<form:form method="post" action="/addScore"
					modelAttribute="applicantScore">

					<br>
					<form:select class="decorated" path="">
						<option id="selectHeader">---------- Select Subject
							---------</option>
						<form:options items="${subjects}" itemLabel="name" />
					</form:select>
					<input id="s1" type="number" onchange="getChar()"/>
						<br>
					<form:select class="decorated" path="">
						<option id="selectHeader">--------- Select Subject
							---------</option>
						<form:options items="${subjects}" itemLabel="name" />
					</form:select>
					<input id = "s2" type="number" onchange="getChar()"/>
						<br>
					<form:select class="decorated" path="">
						<option id="selectHeader">--------- Select Subject
							---------</option>
						<form:options items="${subjects}" itemLabel="name" />
					</form:select>
					<input id="s3" type="number" onchange="getChar()"/>
					<br>
					<input type="button"  class="myScore" value="My score" onclick="addition()"><br>
					<form:input type="text" class = "result" id="result" path="score"/>
					<button type="submit" class ="saveScore">Save my Score</button>
				</form:form>
				
				
        
      </div>
      <div class="col-lg-6">
      <h3>My request</h3>
      	<table class="table table-bordered">
									<thead>
										<tr>
											<th>Id</th>
											<th>Faculty</th>
											<th>Faculty grade</th>
											<th>My score</th>
											
											<th>Status</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${myRequests}" var="request">
												<tr>
												<td class="req_id">${request.id}</td>
												<td title="${request.faculty}">${request.faculty.name}</td>
												<td >${request.faculty.grade}</td>
												<td >${applicant.score}	</td>
												<td class="status">${request.status}</td>
												<td> <a class="delete requestToDelete"
													title="Delete" data-toggle="tooltip"><i
														class="material-icons"> &#xE872;</i></a></td>
											</tr>
									</c:forEach>
										
									</tbody>
								</table>
								<div>
								<br>
								<h3>Yo can send request here</h3>
      <form:form method="post" action="/addRequest"
									modelAttribute="newRequest">
     
                  
                  <form:select id="uexperience" class="decorated" path="faculty">
                  <option id="selectHeader">-------------- Select Faculty --------------</option>
                              <form:options items="${faculties}" itemValue="id" itemLabel="name" />
              
                  </form:select>
             
		<button type="submit" class="myRequest">Send request</button>
        </form:form>
 </div>
    </div>
  </div>
   </div>
</body>
</html>