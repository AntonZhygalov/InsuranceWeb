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
		program
		<c:forEach var="program" items="${programs}">
			<input type="radio" name="program" value="${program.id}">${program.program}
		</c:forEach>
		franchise
		<a:forEach var="franchise" items="${franchises}">
			<input type="radio" name="franchise" value="${franchise.id}">${franchise.franchise}
		</a:forEach>
		zone
		<s:forEach var="zone" items="${zones}">
			<input type="radio" name="zone" value="${zone.id}">${zone.zone}
		</s:forEach> 
		additionalConditions
		<z:forEach var="additionalConditions"
			items="${additionalConditionses}">
			<input type="radio" name="additionalConditions" value="${zone.id}">${additionalConditions.additionalConditions}
		</z:forEach>
		insuranceAmount
		<x:forEach var="insuranceAmount" items="${insuranceAmounts}">
			<input type="radio" name="insuranceAmount"
				value="${insuranceAmount.id}">${insuranceAmount.insuranceAmount}
		</x:forEach>
		<!-- 
		franchise <input type="text" name="franchise"> 
		zone <input type="text" name="zone"> 
		additionalConditions <input	type="text" name="additionalConditions"> 
		insuranceAmount <input  type="text" name="insuranceAmount">  -->

		limitDay <input type="text" name="limitDay"> fromDay <input
			type="text" name="fromDay"> fromMonth <input type="text"
			name="fromMonth"> fromYear <input type="text" name="fromYear">
		person <input type="text" name="person">
		<button type="submit">Submit</button>
	</form>



</body>
</html>