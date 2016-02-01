<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/demos/style.css">

</head>
<body>
	<form action="insertProgram" method="post">
		<h2>Input Data</h2>
		<div >
			<p>name</p><p> <input type="text" name="name"></p>
		</div>
		<div>
			<p>coef </p><p><input type="text" name="coef"></p>
		</div>
		<div>
			<button type="submit">Submit</button>
		</div>
	</form>
	<form action="insertRemoveProgram" method="post">
		<h2>Input Data</h2>
		<div >
			<p>name</p><p> <input type="text" name="name"></p>
		</div>
		
		<div>
			<button type="submit">Submit</button>
		</div>
	</form>
		

</body>
</html>