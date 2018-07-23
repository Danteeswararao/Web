<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Student Form Demo</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student" >
	<p>First Name :<form:input path="firstName" /> </p>
	<p>Last Name :<form:input path="lastName" /> </p>
	<p>Country : 
		<form:select path="country">
		<form:options items="${student.countryOptions}" />
		</form:select>
		</p>
	<p>Favorite Language : 
	<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}" /></p>
	<p>Operating System : 
	Linux : <form:checkbox path="operatingSystems" value="Linux"/>
	Mac OS : <form:checkbox path="operatingSystems" value="Mac OS"/>
	Windows : <form:checkbox path="operatingSystems" value="Windows"/></p>
	<input type="submit" value="Submit" />
	</form:form>
</body>
</html>