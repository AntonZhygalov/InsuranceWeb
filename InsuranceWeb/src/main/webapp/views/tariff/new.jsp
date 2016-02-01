<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd"
		});

	});
</script>
<link rel="stylesheet" href="/resources/demos/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="z"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x"%>
 <style type="text/css">
   body { 
    background-color: #E0F2F7;
   } 
   .dropdown{ margin-bottom: 20px;}
  </style>
<body>
	<form action="insertTafiff" method="post">
		<h2>Input Data</h2>
		<div class="dropdown">
			<p>program</p>
			<select name="program" class="btn btn-default dropdown-toggle">
				<c:forEach var="program" items="${programs}">
					<option value="${program.id}">${program.program}</option>
				</c:forEach>
			</select>
		</div>

		<div class="dropdown">
			<p>franchise</p>
			<select name="franchise" class="btn btn-default dropdown-toggle">
				<a:forEach var="franchise" items="${franchises}">
					<option value="${franchise.id}">${franchise.sumFranchise}</option>
				</a:forEach>
			</select>
		</div>

		<div class="dropdown">
			<p>zone</p>
			<select name="zone" class="btn btn-default dropdown-toggle">
				<s:forEach var="zone" items="${zones}">
					<option value="${zone.id}">${zone.zone}</option>
				</s:forEach>
			</select>
		</div>

		<div class="dropdown">
			<p>additionalConditions</p>
			<select name="additionalConditions"
				class="btn btn-default dropdown-toggle">
				<z:forEach var="additionalConditions"
					items="${additionalConditions}">
					<option value="${additionalConditions.id}">${additionalConditions.additionalConditions}</option>
				</z:forEach>
			</select>
		</div>

		<div class="dropdown">
			<p>insuranceAmount</p>
			<select name="insuranceAmount"
				class="btn btn-default dropdown-toggle">
				<x:forEach var="insuranceAmount" items="${insuranceAmounts}">
					<option value="${insuranceAmount.id}">${insuranceAmount.sumInsurance}</option>
				</x:forEach>
			</select>
		</div>



<!-- 		<div class="input"> -->
<!-- 			<p>limitDay</p> -->
<!-- 			<p> -->
<!-- 				<input type="text" name="limitDay" required pattern="^[ 0-9]+$"> -->
<!-- 			</p> -->
<!-- 		</div> -->
		   
		   
		   
		   <div class="dropdown">
			<p>limitDay</p>
			<select name="limitDay" class="btn btn-default dropdown-toggle">
				
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="40">40 multy</option>
					<option value="60">60 multy</option>
					<option value="90">90 multy</option>
					<option value="120">120 multy</option>
					<option value="160">160 multy</option>
					<option value="180">180 multy</option>
					<option value="360">360 multy</option>
			
			</select>
		</div>
		   
		   
		   
		   
		   
		<div class="input">
			<p>date :</p>
			<p>
				<input type="text" id="datepicker" name="date" required>
			</p>
		</div>
		<div class="input">
			<p>person</p>
			<p>
				<input type="text" name="person" required pattern="^[ 0-9]+$">
			</p>
		</div>
		<div class="input">
			<button type="submit">Submit</button>
		</div>
	</form>



</body>
</html>