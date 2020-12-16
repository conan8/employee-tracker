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
			
				<input type=button value="Add Employee" 
					onclick="window.location.href='add-employee-form.jsp'; return false;"
					class="add-student-button"
				/>
				
				<input type=button value="Remove Employee" 
					onclick="window.location.href='remove-employee-form.jsp'; return false;"
					class="add-student-button"
				/>
				
				<br>
				
				<c:choose>
					<c:when test = "${update == 1}">
			        	New employee not added - similar one was discovered on the list.
			        	<br>
			        	Fullname: ${fullname}
			        	<br>
			        	Approximate matches: ${approximate_matches_list}
			        </c:when>
			         
			        <c:when test = "${update == 2}">
			        	Found employee or approximate employee - and removed succesfully.
			        	<br>
			        	Email: ${email}
			        	<br>
			        	Approximate matches: ${approximate_matches_list}
			        </c:when>
			        
			        <c:when test = "${update == 3}">
			        	New employee was not found on the list and added succesfully.
			        </c:when>
			        
			        <c:when test = "${update == 4}">
			        	Employee or approximate one not found on the list and not removed.
			        </c:when>
			         	
			        <c:otherwise>
			        	No update.
			        </c:otherwise>
				</c:choose>
				
				<br>
				<br>
			
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