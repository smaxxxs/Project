<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Gandalf - from here -> https://codepen.io/anjanas_dh/pen/ZMqKwb -->
<meta charset="ISO-8859-1">
<title>${error}</title>
<link rel="stylesheet"  href="/css/403.css" />
</head>
<body>
<div class="gandalf">
  <div class="fireball"></div>
  <div class="skirt"></div>
  <div class="sleeves"></div>
  <div class="shoulders">
    <div class="hand left"></div>
    <div class="hand right"></div>
  </div>
  <div class="head">
    <div class="hair"></div>
    <div class="beard"></div>
  </div>
</div>
<div class="message">
<h1> ${error} - You Shall Not Pass</h1>
<p>Uh oh, Gandalf is blocking the way!<br/>Maybe you have a typo in the url? Or you meant to go to a different location? Like...Hobbiton?</p>
<br><a href="/"> Go Home!!!</a>
</div>
</body>
</html>