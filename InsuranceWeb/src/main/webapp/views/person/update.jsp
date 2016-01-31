<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	<form action="insertUpdatePersonId" method="post">
	<table>
	
		<thead>
			<tr>
				<th>Id</th>
				<th>number</th>
				<th>Name</th>
				<th>addres</th>
				<th>date registration</th>
				<th>date of birthsday</th>
				<th>identification</th>
				<th>serial of passport</th>
				<th>number of passport</th>
			</tr>
		</thead>
		<tbody>


			<tr>

				<td><input type="text" name="id" value="${person.id}"></td>
				<td><input type="text" name="number" value="${person.number}"></td>
				<td><input type="text" name="fNamelName"
					value="${person.fNamelName}"></td>
				<td><input type="text" name="addres" value="${person.addres}"></td>
				<td><input type="text" name="dateOfRegistration"
					value="${person.dateOfRegistration}"></td>
				<td><input type="text" name="dateOfBirsthday"
					value="${person.dateOfBirsthday}"></td>
				<td><input type="text" name="identification"
					value="${person.identification}"></td>
				<td><input type="text" name="passportSeries"
					value="${person.passportSeries}"></td>
				<td><input type="text" name="passportNumber"
					value="${person.passportNumber}"></td>


			</tr>

		</tbody>
	</table>
	<div>
		<button type="submit">Submit</button>
	</div>
	</form>
</body>
</html>