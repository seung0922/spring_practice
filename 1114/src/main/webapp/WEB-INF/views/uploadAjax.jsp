<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<input type='file' name='uploadFile' multiple>
	<button id="loadBtn">UPLOAD</button>
	
	<style>
	.uploadResult {
		width: 100vw;
		height: 20vh;
		display: flex;
		flex-direction: row;
		justify-content: center;
		background-color: hotpink;
	}
	
	.uploadUl {
		display: flex;
		flex-direction: row;
		justify-content: center;
		list-style: none;
		margin: 5em;
	}
	
	.uploadUl li {
		width: 100px;
		height: 150px;
		background-color: pink;
		border: 1px solid yellow;
		border-radius: 5px;
		margin-left: 1em;
	}
	</style>
	
	<div class="uploadResult">
		<ul class="uploadUl">

		</ul>
	</div>
	
	<form id="actionForm" action="/downFile" method="get">
		<input type="hidden" name="fname">
	</form>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>

	<script
		src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>

	<script>
		var $actionForm = $('#actionForm');	
	
		function down(fileName) {
			$actionForm.find("input[name='fname']").val(fileName);
			$actionForm.submit();
			
		}
		
		$(document).ready(function() {
			
			var $listUL = $('.uploadUl');
			
			$("#loadBtn").on("click", function(e) {
				
				var formData = new FormData();
				var inputFile = $("input[name='uploadFile']");
				var files = inputFile[0].files;
				
				console.log(files);
				
				//add filedate to formdata
				for (var i = 0; i < files.length; i++) {
					formData.append("uploadFile", files[i]);
				}
				
				$.ajax({
					url : '/uploadAjaxAction',
					processData : false,
					contentType : false,
					data : formData,
					type : 'POST',
					success : function(result) {
						console.log(result);
						
						var str = "";
						
						for(var i=0; i<result.length; i++) {
							
							var item = result[i];

							str += "<li onclick='javascript:down(\"" + item.uuid + "\")'>";
							
							console.log(item);
							
							str += item.fileName;
							
							if(item.image) {
								str += "<img src='/viewFile?fname=s_" + item.uuid + "'/>";
							} else {
								str += "<div>" + item.uuid + "</div>";
							}
							
							str += "</li>";
							
						} //end for
						
						$listUL.append(str);
					}
				}); //$.ajax
			});
		});
	</script>
	
</body>
</html>