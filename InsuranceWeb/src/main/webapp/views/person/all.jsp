<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Persons:</h2>
	<table>
		<thead>
			<tr >
				<th>Id</th>
				<th>number</th>
				<th>Name</th>
				<th>addres</th>
				<th>date registration</th>
				<th>date birthday</th>				
				<th>identification</th>
				<th>serial of passport</th>
				<th>number of passport</th>
			</tr>
		</thead>
		<tbody>
			<!-- This is JSTL foreach cycle that allows web page to pass through collection. Items - attribute name, which was given at controller method -->
			<c:forEach var="person" items="${persons}">
				<tr>
					<td>${person.id}</td>
					<td>${person.number}</td>
					<td>${person.fNamelName}</td>
					<td>${person.addres}</td>
					<td>${person.dayOfregistration}</td>
					<td>${person.dayOfBirthday}</td>
					<td>${person.identification}</td>
					<td>${person.passportSeries}</td>
					<td>${person.passportNumber}</td>
					

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="createNewPersons">Create Person</a>
	<sec:authorize access="hasRole('ADMIN')">
	<a href="removePerson">Remove Person</a>
	</sec:authorize>
</body>
</html>