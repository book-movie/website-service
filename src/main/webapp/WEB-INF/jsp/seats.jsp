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
	<h1>BooK Your Seat</h1>
	<h3>${screen.theatreName}</h3>
	<h3>${screen.theatreAddress}</h3>
	<h3>${screen.date}</h3>
	<h3>${screen.startTime}</h3>
	<table>

		<jstl:forEach var="seat" items="${seatAvailable}">
			<tr>
				<td>Seat Type :<input type="text" value="${seat.key}" readonly>
					Available: <input type="number" value="${seat.value}" readonly></td>
			</tr>
		</jstl:forEach>
	</table>
	
	
	<form>
		<select name="seatType">
			<jstl:forEach var="seat" items="${seatAvailable}">
				<option>${seat.key}</option>
			</jstl:forEach>
		</select>
	
	
	<jstl:forEach var="seat" items="${seatAvailable}">
				<input type="number" name="noOfSeatSelected" min="1" max="${seat.value}">
			</jstl:forEach>
			
			<input type="submit" value="Book Ticket">
	</form>
</body>
</html>