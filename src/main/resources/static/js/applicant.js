	
		function addition() {
			var s1 = parseInt(document.getElementById('s1').value);
			var s2 = parseInt(document.getElementById('s2').value);
			var s3 = parseInt(document.getElementById('s3').value);
 
			if (isNaN(s1)==true) s1=0;
			if (isNaN(s2)==true) s2=0;
			if (isNaN(s3)==true) s3=0;
 
			var s = s1+s2+s3;
 
			document.getElementById('result').value =  s;
		}
		
		 function getChar(event) {
		      if (event.which == null) {
		        if (event.keyCode < 32) return null;
		        return String.fromCharCode(event.keyCode) // IE
		      }

		      if (event.which != 0 && event.charCode != 0) {
		        if (event.which < 32) return null;
		        return String.fromCharCode(event.which) 
		      }

		      return null; 
		    }
		 
			// Delete request
			$(document).on("click", ".requestToDelete", function() {
				var id = $(this).parents("tr")
				.find(".req_id").html();
				if (confirm("Are you sure to delete equest witd id="+id)){
						$.ajax({
						url : "/deleteRequest",
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