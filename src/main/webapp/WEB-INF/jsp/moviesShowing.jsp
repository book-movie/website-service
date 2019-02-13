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
<table>
	<jstl:forEach var="movie" items="${movies}">
		
			<!-- <input type="text" name="movieName" value=${movie.movieName} -->
			<a href="getMovieDetails?movieName=${movie.movieName}"><img src="${movie.moviePoster}"/></a>
		
	</jstl:forEach>
</table>	
</body>
</html>