<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Details</title>
</head>
<body>
	<form action="theatreShowingMovie">
	<img src="${moviePoster}"/>
		<div>
			<div>
				<b>MovieName: </b>${movie.movieName}
			</div>
			<div>
				<b>Director: </b>${movie.director}
			</div>
			<div>
				<b>Description: </b>${movie.description}
			</div>
			<div>
				<b>Release Date: </b>${movie.releaseDate}
			</div>
			<div>
				<b>Running Time: </b>${movie.runtime.hours}:${movie.runtime.minutes}
			</div>

			<div>
				<b>Cast: </b>
				<ul>
					<jstl:forEach var="cast" items="${movie.cast}">
						<div><b>Name: </b>${cast.name}</div>
						<div><b>Bio: </b>${cast.bio}</div>
					 <div><b>role:</b>${cast.role}</div>
					 <hr>
					</jstl:forEach>
				</ul>
			</div>

			<div>
				<b>Crew: </b>
				<ul>
					<jstl:forEach var="crew" items="${movie.crew}">
						 <div><b>Name: </b>${crew.name}</div>
						 <div><b>Bio: </b>${crew.bio}</div>
						 <div><b>role: </b>${crew.role}</div>
						 <hr>
					</jstl:forEach>
				</ul>
			</div>
		</div>
			<input type="submit" value="Book Ticket">
	</form>
</body>
</html>