<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<img src="${moviePoster}" />
	
	<form></form>
	<jstl:forEach var="dateFromTheatre" items="${dates}">
		<a href="/theatreShowingMovieByDate?dateAsString=${dateFromTheatre}">${dateFromTheatre}</a>
	</jstl:forEach>
	<%-- 	this is working ------>   <%=java.time.LocalDate.now().getDayOfMonth()   %>  --%>
	<%--  	not working ----->   		${java.time.LocalDate.now()}  --%>
	<table style="border: 1px solid black; width: 100%">
		<tr>
			<th>Theatre</th>
			<th>Show Time</th>
		</tr>
		<jstl:forEach var="theatre" items="${theatres}">
			<tr>
				<td><b>${theatre.theatreName}</b> (
					${theatre.theatreAddress.city}, ${theatre.theatreAddress.area})</td>
				<td><a href="/chooseSeats?screening=${theatre}">${theatre.startTime}</a></td>
			</tr>

		</jstl:forEach>
	</table>
</body>
</html>