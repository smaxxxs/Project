<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title><spring:message code='home.title'/>!!!</title>

<!-- Bootstrap core CSS -->
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/scrolling-nav.css" rel="stylesheet">
<link href="/css/home.css" rel="stylesheet">
	<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		var selItem = localStorage.getItem("locales");
		$('#locales').val(selItem ? selItem : 'en');
		$("#locales").change(function() {
			var selectedOption = $('#locales').val();
			if (selectedOption) {
				window.location.replace('?lang=' + selectedOption);
				localStorage.setItem("locales", selectedOption);
			}
		});
	});
</script>
</head>

<body id="page-top" class="text-white">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Home</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="choice" >
				<fieldset>
					<label><spring:message code="home.choose_language" /></label> <select
						id="locales">
						<option value="en_US"><spring:message code='home.english'/></option>
						<option value="uk"><spring:message code='home.ukrainian'/></option>

 					</select>
				</fieldset>
			</div>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="login"><spring:message code="home.signin" /></a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about"><spring:message code='home.about'/></a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#services"><spring:message code='home.admission'/></a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#contact"><spring:message code='home.contact'/></a></li>
				</ul>
			</div>
		</div>
		
	</nav>

	<header class="bg_1 text-white">
		<div class="container text-center">
			<h1><spring:message code='home.main_head'/></h1>
			<p class="lead"><spring:message code='home.main_head_exp'/></p>
		</div>
	</header>

	<section id="about" class="bg_2">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>Hogwarts</h2>
					<p class="lead">School of Witchcraft and Wizardry, commonly
						shortened to Hogwarts, is a fictional British school of magic for
						students aged eleven to eighteen, and is the primary setting for
						the first six books in J. K. Rowling's Harry Potter series.

						Rowling has suggested that she may have inadvertently taken the
						name from the hogwort plant (Croton capitatus), which she had seen
						at Kew Gardens some time before writing the series, although the
						names "The Hogwarts" and "Hoggwart" appear in the 1954 Nigel
						Molesworth book How to Be Topp by Geoffrey Willans. Hogwarts
						school was voted as the 36th best Scottish educational
						establishment in a 2008 online ranking, outranking Edinburgh's
						Loretto School. According to a director of the Independent Schools
						Network Rankings, it was added to the schools listing "for fun"
						and was then voted on.</p>
					<a href="https://en.wikipedia.org/wiki/Hogwarts"> To read more
						about you can here</a>
				</div>
			</div>
		</div>
	</section>

	<section id="services" class="bg_3">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>Admission</h2>
					<p class="lead">According to the novels, admission to Hogwarts
						is selective, in that children who show magical ability will
						automatically gain a place, and squibs cannot attend the school as
						students (though they can work there in other roles, as Argus
						Filch does). A magical quill at Hogwarts detects the birth of
						magical children and writes their names into a large parchment
						book, but there is no admission test because "you are either
						magical or you are not." Every year, a teacher checks this book
						and sends a letter to the children who are turning eleven.
						Acceptance or refusal of a place at Hogwarts must be posted by 31
						July. The letter also contains a list of supplies like spell
						books, uniform, and other things that the student will need. The
						prospective student is expected to buy all the necessary
						materials, normally from shops in Diagon Alley, a concealed street
						near Charing Cross Road in London that can be found behind the
						wizarding pub, The Leaky Cauldron. Students who cannot afford
						their supplies can receive financial aid from the school, as
						happened with the young orphan Tom Riddle.</p>
					<a href="https://en.wikipedia.org/wiki/Hogwarts#Admission"> To
						read more about you can here</a>


				</div>
			</div>
		</div>
	</section>

	<section id="contact" class="bg_4">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>Contact us</h2>
					<p class="lead">You can contact us by some ways:</p>
					<ul>
						<li><a href="login">Login and message to us</a></li>
						<li><a
							href="https://en.wikipedia.org/wiki/Hogwarts#Hogwarts_Express">Come
								here on Hogwarts Express</a></li>
						<li>Or use magic more, and we will find you ouselves!</li>
					</ul>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom JavaScript for this theme -->
	<script src="js/scrolling-nav.js"></script>

</body>

</html>
