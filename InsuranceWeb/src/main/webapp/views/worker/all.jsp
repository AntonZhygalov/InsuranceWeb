<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="z"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Settings:</h2>
	<div class="new">
		<form action="insertWorker" method="post">
			<div class="name">
				<p class="user">create worker</p>
			</div>
			<div class="useraddleft">
				<p class="user">name</p>
				<p class="user">
					<input type="text" name="name">
				</p>
			</div>
			<div class="useraddright">
				<p class="user">password</p>
				<p class="user">
					<input type="text" name="password">
				</p>
			</div>

			<div class="submit">
				<button type="submit">Submit</button>
			</div>
		</form>
	</div>

	<div class="new">
		<p class="user">workers:</p>
		<table class="new">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>password</th>

				</tr>
			</thead>
			<tbody>
				<!-- This is JSTL foreach cycle that allows web page to pass through collection. Items - attribute name, which was given at controller method -->
				<c:forEach var="worker" items="${workers}">
					<tr>
						<td>${worker.id}</td>
						<td>${worker.workerName}</td>
						<td>${worker.workerPassword}</td>
						<td class="myInvisible"><form action="insertRemoveWorker"
							method="post">
							<button  class="glyphicon glyphicon-remove"  name="number"
								value="${worker.id}" type="submit">
							
							</button>
						</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="new">
		<form action="insertRemoveWorker" method="post">
			<div class="name">
				<p class="user">remove user</p>
			</div>
			<div class="useraddleft">
				<p class="user">id</p>
				<input type="text" name="number">
			</div>
			<div class="submit">
				<button type="submit">Submit</button>
			</div>
		</form>
	</div>

	<div class="new">
		<p class="user">zones:</p>
		<table class="new">
			<thead>
				<tr>
					<th>Id</th>
					<th>name</th>
					<th>coef</th>

				</tr>
			</thead>
			<tbody>
				<!-- This is JSTL foreach cycle that allows web page to pass through collection. Items - attribute name, which was given at controller method -->
				<c:forEach var="zone" items="${zones}">
					<tr>
						<td>${zone.id}</td>
						<td>${zone.zone}</td>
						<td>${zone.coef}</td>
						<td class="myInvisible"><form action="insertRemoveZone"
							method="post">
							<button  class="glyphicon glyphicon-remove"  name="name"
								value="${zone.id}" type="submit">
							
							</button>
						</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a href="createNewZone"><button type="button" class="button" >create/remove Zone</button></a>

	<div class="new">
		<p class="user">additionalConditions:</p>
		<table class="new">
			<thead>
				<tr>
					<th>Id</th>
					<th>name</th>
					<th>coef</th>

				</tr>
			</thead>
			<tbody>
				<!-- This is JSTL foreach cycle that allows web page to pass through collection. Items - attribute name, which was given at controller method -->
				<c:forEach var="additionalCondition" items="${additionalConditions}">
					<tr>
						<td>${additionalCondition.id}</td>
						<td>${additionalCondition.additionalConditions}</td>
						<td>${additionalCondition.coef}</td>
							<td class="myInvisible"><form action="insertRemoveAdditionalConditions"
							method="post">
							<button  class="glyphicon glyphicon-remove"  name="name"
								value="${additionalCondition.id}" type="submit">
							
							</button>
						</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a href="createNewAdditionalConditions"><button type="button" class="button" >create/remove AdditionalConditions</button></a>

	<div class="new">
		<p class="user">franchise:</p>
		<table class="new">
			<thead>
				<tr>
					<th>Id</th>
					<th>name</th>
					<th>coef</th>

				</tr>
			</thead>
			<tbody>
				<!-- This is JSTL foreach cycle that allows web page to pass through collection. Items - attribute name, which was given at controller method -->
				<c:forEach var="franchise" items="${franchises}">
					<tr>
						<td>${franchise.id}</td>
						<td>${franchise.sumFranchise}</td>
						<td>${franchise.coef}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<a href="createNewFranchise"><button type="button" class="button">create/remove Franchise</button></a>
	<div class="new">
		<p class="user">InsuranceAmount:</p>
		<table class="new">
			<thead>
				<tr>
					<th>Id</th>
					<th>name</th>
					<th>coef</th>

				</tr>
			</thead>
			<tbody>
				<!-- This is JSTL foreach cycle that allows web page to pass through collection. Items - attribute name, which was given at controller method -->
				<c:forEach var="insuranceAmount" items="${insuranceAmounts}">
					<tr>
						<td>${insuranceAmount.id}</td>
						<td>${insuranceAmount.sumInsurance}</td>
						<td>${insuranceAmount.coef}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a href="createNewInsuranceAmount"><button type="button" class="button">create/remove insuranceAmount</button></a>

	<div class="new">
		<p class="user">program:</p>
		<table class="new">
			<thead>
				<tr>
					<th>Id</th>
					<th>name</th>
					<th>coef</th>

				</tr>
			</thead>
			<tbody>
				<!-- This is JSTL foreach cycle that allows web page to pass through collection. Items - attribute name, which was given at controller method -->
				<c:forEach var="program" items="${programs}">
					<tr>
						<td>${program.id}</td>
						<td>${program.program}</td>
						<td>${program.coef}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<a href="createNewProgram"><button type="button" class="button">create/remove Program </button></a>
</body>
</html>