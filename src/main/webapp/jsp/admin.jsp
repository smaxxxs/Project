	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello ${adminNick}</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet"  href="/css/admin.css" />
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="/js/admin.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Admin Navbar</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Fuculties</a></li>
      <li><a href="#">Requests</a></li>
      <li><a href="#">Add new Admin</a></li>
    </ul>
    <button class="btn btn-danger navbar-btn">LogOut</button>
  </div>
</nav>

<div class="container">
 <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2> <b>Fuculties</b></h2></div>
                    <div class="col-sm-4">
                        <button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button>
                    </div>
                </div>
            </div>
            <form:form method="post" action="/addFaculty" modelAttribute ="newFaculty">
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
                        <td>${faculty.id}</td>
                        <td>${faculty.name}</td>
                        <td>${faculty.places}</td>
                        <td>${faculty.subjects}</td>
                        <td>${faculty.applicants}</td>
                        <td>
							<a class="add" title="Add" data-toggle="tooltip"><i class="material-icons">&#xE03B;</i></a>
                            <a class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                            <a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                        </td>
                        </tr>
                   </c:forEach>
 					<tr>
 						<td></td>
                        <td><form:input type="text" class="form-control" path ="name" name="name" id="name"/></td>
                        <td><form:input type="text" class="form-control" path="places" name="department" id="department"/></td>
                        <td><form:input type="text" class="form-control" path="subjects" name="phone" id="phone"/></td>
                        <td></td>
                        <td><input type="submit" value="    add    " /></td>
                                         </tr> 
                </tbody>
            </table>
            </form:form>
        </div>
</div>
</body>
</html>