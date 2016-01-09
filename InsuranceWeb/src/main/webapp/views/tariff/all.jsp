<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Tariffs:</h2>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>program</th>
				<th>franchise</th>
				<th>zone</th>
				<th>additionalConditions</th>
				<th>insuranceAmount</th>
				<th>limitDay</th>
				<th>fromDate</th>
				<th>untilDate</th>
				<th>cost</th>
				<th>person</th>
			</tr>
		</thead>
		<tbody>
			<!-- This is JSTL foreach cycle that allows web page to pass through collection. Items - attribute name, which was given at controller method -->
			<c:forEach var="tariff" items="${tariffs}">
				<tr>
					<td>${tariff.id}</td>
					<td>${tariff.program}</td>
					<td>${tariff.franchise}</td>
					<td>${tariff.zone}</td>
					<td>${tariff.additionalConditions}</td>
					<td>${tariff.insuranceAmount}</td>
					<td>${tariff.limitDay}</td>
					<td>${tariff.fromDate}</td>
					<td>${tariff.untilDate}</td>
					<td>${tariff.cost}</td>
					<td>${tariff.personId}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="createNewTariff">Create Tariff</a>
	<a href="removeTariff">Remove Tariff</a>
</body>
</html>