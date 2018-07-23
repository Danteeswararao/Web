<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Customer Registration Form</title>
	<style>
		.error {color:red}
	</style>
</head>
<body>
	<form:form action="processForm" modelAttribute="customer">
	<table>
	<tr><td>First Name : </td><td><form:input path="firstName"/></td></tr>
	<tr><td>Last Name(*) :</td><td><form:input path="lastName"/>
	<form:errors path="lastName" cssClass="error" />
	</td></tr>
	<tr><td>Free Passes(*) : </td><td> <form:input path="freePasses"/>
	<form:errors path="freePasses" cssClass="error" /> 
	</td></tr>
	<tr><td>Postal Code : </td><td> <form:input path="postalCode"/>
	<form:errors path="postalCode" cssClass="error" /> 
	</td></tr>
	<tr><td>Course Code : </td><td> <form:input path="courseCode"/>
	<form:errors path="courseCode" cssClass="error" /> 
	</td></tr>
	<tr><td><input type="submit" value="submit"/></td><td></td></tr>
	</table>
	</form:form>
</body>
</html>