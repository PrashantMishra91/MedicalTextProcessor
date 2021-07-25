<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.half-width {
	width: 40%;
	display: inline-block;
}

.quater-width {
	width: 25%;
	display: inline-block;
	vertical-align: top;
	margin-top: 20px;
}

.display-block {
	display: block;
	margin-top: 30px;
}
</style>
<!-- <script type="text/javascript">
	function submit() {
		var outputPathValue = document.getElementById('outputPath').value;
		var errorTag = document.getElementByClassName('error')[0];
		if(outputPathValue !== "") {
			errorTag.classList.add('hidden');
			return true;
		} else {
			
			errorTag.classList.remove('hidden');
			return false;
		}
	}
</script> -->
<meta charset="ISO-8859-1">
<title>Processor</title>
</head>
<body>
	<h2 align="center">Medical Text Processor</h2>
	<form method="post" action="SubmitFile">
		<div class="half-width">
			<textarea rows="35" cols="60" name="medicaltext">Enter the text here... This is a mandatory Field</textarea>
		</div>
		<div class="quater-width">
			<h5>Enter location of the processed file to be saved</h5>
			<input type="text" name="outputpath" /> <span>(Please mention
				the whole path)</span> <br> <input type="submit" value="Enter"
				class="display-block" />
		</div>
		<div class="quater-width">
			<p>Sample Paragraph</p>
		</div>
	</form>
</body>
</html>