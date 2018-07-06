<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Save Customer</title>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Insert Employee</h2>
			</div>
		</div>
		<div id="container">
			<h3>Save Customer</h3>
			<form:form action="saveEmployee" modelAttribute="employee" method="POST">
				<form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td>First Name:</td>
							<td><form:input path="firstName"/></td>
						</tr>
						<tr>
							<td>Last Name:</td>
							<td><form:input path="lastName"/></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><form:input path="email"/></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear;both;">
				<a href="${pageContext.request.contextPath}/employee/list">Back to list</a>
			</div>
		</div>
	
	
	</body>



</html>