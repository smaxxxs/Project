<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"  href="/css/login.css" />
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>login/register</title>

</head>
<body>



<div class="cotn_principal">
<a href="/"><input class="button4" type="button" value="Home"/></a>
<h1 style="color:red">${message}</h1>
<div class="cont_centrar">

  <div class="cont_login">
<div class="cont_info_log_sign_up">
      <div class="col_md_login">
<div class="cont_ba_opcitiy">
        
        <h2>LOGIN</h2>  
  <p>login for applicants and magic admins.</p> 
  <button class="btn_login" onclick="cambiar_login()">LOGIN</button>
  </div>
  </div>
<div class="col_md_sign_up">
<div class="cont_ba_opcitiy">
  <h2>SIGN UP</h2>

  
  <p>You can register here.</p>

  <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
</div>
  </div>
       </div>

    
    <div class="cont_back_info">
       <div class="cont_img_back_grey">
       <img src="/img/login_bg.jpg" alt="" />
       </div>
       
    </div>
				<div class="cont_forms">
					<div class="cont_img_back_">
						<img src="/img/login_bg.jpg" alt="" />
					</div>
					<div class="cont_form_login">
						<a href="#" onclick="ocultar_login_sign_up()"><i
							class="material-icons"></i></a>
						<h2>LOGIN</h2>
						<form:form method="post" action = "/userlogin" modelAttribute="userlogin" class="loginform" >
							
							<spring:bind path="nickName">
								<form:input type="text" placeholder="NickName" path="nickName" /> 
							</spring:bind>
							<spring:bind path="password">
							<form:input
								type="password" placeholder="Password" path="password"/>
								</spring:bind>
							<button class="btn_login" type="submit" onclick="cambiar_login()">LOGIN</button> 
							
						</form:form>
					</div>

					<div class="cont_form_sign_up">
						<a href="#" onclick="ocultar_login_sign_up()"><i
							class="material-icons"></i></a>
						<h2>SIGN UP</h2>
						<form:form method="post" action = "/userregister" modelAttribute="userregister" class = "registerform">
							<form:input type="text" placeholder="Surname" path="surname"/>
							<form:input type="text" placeholder="Name" path="name" /> 
							<form:input type="text"	placeholder="Nick Name" path="nickName"
								title="Your login  to this site" /> 
							<form:input type="password"	placeholder="Password" path="password" /> 
							
							<button class="btn_sign_up" type="submit">SIGN UP</button>
						</form:form>
					</div>

				</div>

			</div>
 </div>
</div>
<script>
    /* ------------------------------------ Click on login and Sign Up to  changue and view the effect
---------------------------------------
*/

function cambiar_login() {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";  
document.querySelector('.cont_form_login').style.display = "block";
document.querySelector('.cont_form_sign_up').style.opacity = "0";               

setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);  
  
setTimeout(function(){    
document.querySelector('.cont_form_sign_up').style.display = "none";
},200);  
  }

function cambiar_sign_up(at) {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
  document.querySelector('.cont_form_sign_up').style.display = "block";
document.querySelector('.cont_form_login').style.opacity = "0";
  
setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
},100);  

setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
},400);  


}    



function ocultar_login_sign_up() {

document.querySelector('.cont_forms').className = "cont_forms";  
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.querySelector('.cont_form_login').style.opacity = "0"; 

setTimeout(function(){
document.querySelector('.cont_form_sign_up').style.display = "none";
document.querySelector('.cont_form_login').style.display = "none";
},500);  
  
  }




</script>
</body>
</html>