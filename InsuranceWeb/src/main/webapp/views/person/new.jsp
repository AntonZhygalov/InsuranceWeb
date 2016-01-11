<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker({dateFormat: "yy-mm-dd"});
   
  });
  </script>
</head>
<body>
	<form action="insert" method="post">
		<h2>Input Data</h2>
		number <input type="text" name="number">
		 full name <input type="text" name="fNamelName">
		 passportSeries <input type="text" name="passportSeries"> 
		 passportNumber <input type="text" name="passportNumber"> 
		identification <input type="text" name="identification"> 
		addres <input type="text"	name="addres"> 
		Date: <input type="text" id="datepicker" name = "dateOfBirthsday">
		<!--yearOfBirstday <input type="text"	name="yearOfBirstday"> 
		mounthOfBirstday <input type="text" name="mounthOfBirstday"> 
		dayOfBirstday <input type="text" name="dayOfBirstday">-->
		<button type="submit">Submit</button>
	</form>
	
</body>
</html>