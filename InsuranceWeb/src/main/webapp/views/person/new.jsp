<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<body  >
	<form action="insert" method="post">
		<h2>Input Data</h2>
		<div class="input">
			<p>number</p><p> <input type="text" name="number" required pattern="^[ 0-9]+$"  title="0-9"></p>
		</div>
		<div class="input">
			<p>full name </p><p><input type="text" name="fNamelName" required pattern="^[А-Яа-яЇїІі\s]+$"  title="Aa-Яя"></p>
		</div>
		<div class="input">
			<p>passportSeries </p><p><input type="text" name="passportSeries" required pattern="[А-Яа-яЇїІі]{2}"  title="КС"></p>
		</div>
		<div class="input">
			<p>passportNumber</p><p> <input type="text" name="passportNumber" required pattern="[0-9]{6}"  title="6 цифер"></p>
		</div>
		<div class="input">
			<p>identification</p> <p><input type="text" name="identification" required pattern="[0-9]{10}"  title="10 цифер"></p>
		</div>
		<div class="input">
			<p>addres</p> <p><input type="text" name="addres" required></p>
		</div>
		<div class="input">
			<p>Date of birthsday: </p><p><input type="text" id="datepicker" name="dateOfBirthsday" required></p>
		</div>

		<div class="input">
			<button type="submit">Submit</button>
		</div>
	</form>

</body>
</html>