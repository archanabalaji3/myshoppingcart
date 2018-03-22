<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${successMessage}
${errorMessage}


<!--  create 3 text fields -->
<form action="/category/">
<table>
<tr>
<td>ID</td>
<td><input type="text" name='id'></td>
</tr>

<tr>
<td>Name</td>
<td><input type="text" name='name'></td>
</tr>

</table>

</form>
Category Management
</body>
</html>