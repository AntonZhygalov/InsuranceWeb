<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd"
		});

	});
</script>
</head>
<body>
	<form action="insert" method="post">
		<h2>Input Data</h2>
		<div style="color:red;">
			<p>number</p><p> <input type="text" name="number"></p>
		</div>
		<div>
			<p>full name </p><p><input type="text" name="fNamelName"></p>
		</div>
		<div>
			<p>passportSeries </p><p><input type="text" name="passportSeries"></p>
		</div>
		<div>
			<p>passportNumber</p><p> <input type="text" name="passportNumber"></p>
		</div>
		<div>
			<p>identification</p> <p><input type="text" name="identification"></p>
		</div>
		<div>
			<p>addres</p> <p><input type="text" name="addres"></p>
		</div>
		<div>
			<p>Date: </p><p><input type="text" id="datepicker" name="dateOfBirthsday"></p>
		</div>

		<div>
			<button type="submit">Submit</button>
		</div>
	</form>

</body>
</html>