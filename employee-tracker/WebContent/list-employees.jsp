<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

	<head>
		<title>EMPLOYEE TRACKER</title>
		
		<link type="text/css" rel="stylesheet" href="css/style.css">
	</head>
	
	<body>
	
		<div id="wrapper">		
			<div id="header">
				<h2>COMPANY XYZ</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>FIRST NAME</th>
						<th>LAST NAME</th>
						<th>EMAIL</th>
					</tr>
					
					<c:forEach var="employee" items="${employee_list}">
										
					<tr>
						<td> ${employee.firstname}</td>
						<td> ${employee.lastname} </td>
						<td> ${employee.email}</td>
					</tr>
					
					</c:forEach>
					
					
				</table>
			</div>
		</div>
	
	</body>

</html>