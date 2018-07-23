<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>
Customer Confirmation Page
</title>
</head>
<body>


The Customer confirmed : ${customer.firstName} ${customer.lastName} and having ${customer.freePasses} Passes 

<br><br>

Postal Code : ${customer.postalCode}

</body>

<br><br>

Course Code : ${customer.courseCode}

</body>
</html>