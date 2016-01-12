<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="z"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x"%>
<body>
	<form action="insertTafiff" method="post">
		<h2>Input Data</h2>
		<div>
			<p>program</p>
			<p><c:forEach var="program" items="${programs}">
				<input type="radio" name="program" value="${program.id}">${program.program}
		</c:forEach></p>
		</div>
		<div>
			<p>franchise</p>
			<p><a:forEach var="franchise" items="${franchises}">
				<input type="radio" name="franchise" value="${franchise.id}">${franchise.sumFranchise}
		</a:forEach></p>
		</div>
		<div>
			<p>zone</p>
			<p><s:forEach var="zone" items="${zones}">
				<input type="radio" name="zone" value="${zone.id}">${zone.zone}
		</s:forEach>
		</p></div>
		<div>
			<p>additionalConditions</p>
			<p><z:forEach var="additionalConditions" items="${additionalConditions}">
				<input type="radio" name="additionalConditions"
					value="${additionalConditions.id}">${additionalConditions.additionalConditions}
		</z:forEach>
		</p></div>
		<div>
			<p>insuranceAmount</p>
			<p><x:forEach var="insuranceAmount" items="${insuranceAmounts}">
				<input type="radio" name="insuranceAmount"
					value="${insuranceAmount.id}">${insuranceAmount.sumInsurance}
		</x:forEach>
		</p></div>

		<div>
			<p>limitDay </p><p><input type="text" name="limitDay"></p>
		</div>
		<div>
			<p>fromDay</p> <p><input type="text" name="fromDay"></p>
		</div>
		<div>
			<p>fromMonth</p> <p><input type="text" name="fromMonth"></p>
		</div>
		<div>
			<p>fromYear</p> <p><input type="text" name="fromYear"></p>
		</div>
		<div>
			<p>person</p> <p><input type="text" name="person"></p>
		</div>
		<div>
			<button type="submit">Submit</button>
		</div>
	</form>



</body>
</html>