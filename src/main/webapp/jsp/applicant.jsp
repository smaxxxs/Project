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
<link rel="stylesheet" href="/css/admin.css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="/js/admin.js"></script>
</head>
<body>
<p> ${applicant}</p>
  <div class="container">
    <div class="col-lg-12">
      <div class="col-lg-6">
        <form:form method="post" action="/addRequest"
									modelAttribute="newRequest">
     
                  <br>
                  <form:select id="uexperience" class="decorated" path="faculty">
                  <option id="selectHeader">-------------- Select Faculty --------------</option>
                              <form:options items="${faculties}" itemValue="id" itemLabel="name" />
              
                  </form:select>
             >
		<button type="submit">Send request</button>
        </form:form>
        
      </div>
 
    </div>
  </div>
</body>
</html>