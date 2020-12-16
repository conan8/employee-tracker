<!DOCTYPE html>

<html>

	<head>
		<title>Remove Employee</title>
		
		<link type="text/css" rel="stylesheet" href="css/style.css">
		<link type="text/css" rel="stylesheet" href="css/add-employee-style.css">
	</head>

	<body>
	
		<div id="wrapper">
			<div id=header>
				<h2>COMPANY XYZ</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Remove Employee</h3>
			
			<form action="EmployeeControllerServlet" method="GET">			
				<input type="hidden" name="command" value="REMOVE">
				
				<table>
					<tbody>						
						<tr>
							<td><label>Email:</label></td>
							<td><input type="text" name="email" /></td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Remove" class="save"/></td>
						</tr>
						
					</tbody>
				</table>		
			</form>
			
			<div style="clear: both;"></div>
			
			<p>
				<a href="EmployeeControllerServlet">Back to list</a>
			</p>
		
		</div>
	
	</body>

</html>