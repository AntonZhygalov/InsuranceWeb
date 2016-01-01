<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="insertTafiff" method="post" >
		<h2>Input Data</h2>
		program <input type="text" name="program"> 
		franchise <input type="text" name="franchise"> 
		zone <input type="text" name="zone"> 
		additionalConditions <input type="text" name="additionalConditions">  
		insuranceAmount <input type="text" name="insuranceAmount"> 
		limitDay <input type="text" name="limitDay"> 
		fromDay <input type="text" name="fromDay"> 
		fromMonth <input type="text" name="fromMonth"> 
		fromYear <input type="text" name="fromYear"> 
		person <input type="text" name="person">
		<button type="submit">Submit</button>
	</form>
	
	
	
</body>
</html>