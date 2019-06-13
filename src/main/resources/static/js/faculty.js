$(document).ready(
		function(){
//			$(".editForm").hide();
		
		function adjust_textarea(h) {
		    h.style.height = "20px";
		    h.style.height = (h.scrollHeight)+"px";
		}		
		$(document).on("click", ".editButton", function() {
			$(".editForm")[0].classList.toggle('invisible');
			
			if ($(".editButton").text() == "Edit")
				{$(".editButton").text('Close').button("refresh");}
			else {$(".editButton").text('Edit').button("refresh");}
		}
		)
		})