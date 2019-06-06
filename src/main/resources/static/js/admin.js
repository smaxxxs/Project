$(document).ready(

		//reload page on last active tab
		function() {
			
			if (location.hash) {
				  $('a[href=\'' + location.hash + '\']').tab('show');
				}
				var activeTab = localStorage.getItem('activeTab');
				if (activeTab) {
				  $('a[href="' + activeTab + '"]').tab('show');
				}

				$('body').on('click', 'a[data-toggle=\'tab\']', function (e) {
				  e.preventDefault()
				  var tab_name = this.getAttribute('href')
				  if (history.pushState) {
				    history.pushState(null, null, tab_name)
				  }
				  else {
				    location.hash = tab_name
				  }
				  localStorage.setItem('activeTab', tab_name)

				  $(this).tab('show');
				  return false;
				});
				$(window).on('popstate', function () {
				  var anchor = location.hash ||
				    $('a[data-toggle=\'tab\']').first().attr('href');
				  $('a[href=\'' + anchor + '\']').tab('show');
				});		
			var actions = $("table td:last-child").html();
			
			// Append table with add row form on add new button click
			$(".add-new").click(function() {
				$(this).attr("disabled", "disabled");
				document.getElementById("name").focus()
				var index = $("table tbody tr:last-child").index();
				$("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
											});
			
			// Add row on add button click
			$(document).on("click", ".add", function() {
//				var empty = false;
//				var input = $(this).parents("tr").find('input[type="text"]');
//				input.each(function() {
//					if (!$(this).val()) {
//						$(this).addClass("error");
//						empty = true;
//					} else {
//						$(this).removeClass("error");
//					}
//				});
//				$(this).parents("tr").find(".error").first().focus();
//				if (!empty) {
//					input.each(function() {
//						$(this).parent("td").html($(this).val());
//					});
					$(this).parents("tr").find(".add, .edit").toggle();
					$(".add-new").removeAttr("disabled");
//				}
			});
			
			// Edit row on edit button click
			$(document).on(
					"click",
					".edit",
					function() {
					
						$(this).parents("tr").find("td:not(:last-child):not(:first-child)").each(
								function() {
									$(this).html(
											'<input type="text" class="form-control appIinput" value="'
													+ $(this).text() + '">');
								});
						$(this).parents("tr").find(".add, .edit").toggle();
						$(".add-new").attr("disabled", "disabled");
					});
			
			// Delete faculty
			$(document).on("click", ".facultyToDelete", function() {
				var name = $(this).parents("tr")
				.find(".faculty_name").html();
				if (confirm("Are you sure to delete //"+name+"// faculty")){
					var facultyId = $(this).parents("tr")
					.find(".faculty_id").html();
					$.ajax({
						url : "/deleteFaculty",
						type : "POST",
						async : false,
						data : {
							val : facultyId
						},
						dataType : 'html',
						success : function() {
							alert("success deleted");
							window.location.reload();
						}
					});
				}
			});
			// Delete Subject
			$(document).on("click", ".subjectToDelete", function() {
				var name = $(this).parents("tr")
				.find(".subject_name").html();
				if (confirm("Are you sure to delete //"+name+"// subject")){
					var subjectId = $(this).parents("tr")
					.find(".subject_id").html();
					$.ajax({
						url : "/deleteSubject",
						type : "POST",
						async : false,
						data : {
							val : subjectId
						},
						dataType : 'html',
						success : function() {
							alert("success deleted");
							window.location.reload();
						}
					});
				}
			});
			
			// Delete applicant
			$(document).on("click", ".applicantToDelete", function() {
				var id = $(this).parents("tr")
				.find(".applicant_id").html();
				if (confirm("Are you sure to delete applicant witd id="+id)){
						$.ajax({
						url : "/deleteApplicant",
						type : "POST",
						async : false,
						data : {
							val : id
						},
						dataType : 'html',
						success : function() {
							alert("success deleted");
							window.location.reload();
						}
					});
				}
			});
			// Edit applicant

			$(document).on("click", ".editApplicantConfirm", function() {
				debugger;
			
				var input = document.getElementsByClassName("appIinput");
				var id= $(this).parents("tr").find(".applicant_id").html();
				var surname= input[0].value;
				var name= input[1].value;
				var score= input[2].value;
				$.ajax({
					url : "/editApplicant",
					type : "POST",
					async : false,
					data : {
						id : id,
						surname: surname,
						name: name,
						score: score
					},
					dataType : 'html',
					success : function() {
						alert("success changed");
						window.location.reload();
					}
				});
				
					
				
			});
			// Edit subject

			$(document).on("click", ".editSubjectConfirm", function() {
				debugger;
			
				var input = document.getElementsByClassName("appIinput");
				var id= $(this).parents("tr").find(".subject_id").html();
				
				var name= input[0].value;
			
				$.ajax({
					url : "/editSubject",
					type : "POST",
					async : false,
					data : {
						id:id,
							name: name
										},
					dataType : 'html',
					success : function() {
						alert("success changed");
						window.location.reload();
					}
				});
				
					
				
			});
			// Change request status
			$(document).on(
					"click",
					".approve",
					function() {
						var reqIdApprove = $(this).parents("tr")
								.find(".req_id").html();
						$.ajax({
							url : "/approve",
							type : "POST",
							async : false,
							data : {
								val : reqIdApprove
							},
							dataType : 'html',
							success : function() {
								alert("success approved");
								window.location.reload();
							}
						});
					});
			$(document).on(
					"click",
					".decline",
					function() {
						var reqIdApprove = $(this).parents("tr")
								.find(".req_id").html();
						$.ajax({
							url : "/decline",
							type : "POST",
							async : false,
							data : {
								val : reqIdApprove
							},
							dataType : 'html',
							success : function() {
								alert("unfortunate applicant!( declined(");
								window.location.reload();
							}
							
						});
					});
		});