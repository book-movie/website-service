<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="deposit" method="put">
<h1>${message}</h1>
	Enter Profile Number: <input type = "text" name="profileId"/><br/>
Enter amount to Add Money Into Your Wallet:<input type = "text" name="currentBalance"><br>
<input type="submit"/>
</form>
</body>
</html>