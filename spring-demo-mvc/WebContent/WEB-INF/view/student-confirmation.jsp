<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Student Confirmation</title>
</head>
<body>

<p> The Student is confirmed : ${student.firstName} ${student.lastName } 

<p>Country : ${student.country}</p>
<p>Favorite Language : ${student.favoriteLanguage }</p>
<p> Operating Systems : </p>
<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
	
	<li> ${temp} </li>
	
	</c:forEach>
</ul>

</body>
</html>