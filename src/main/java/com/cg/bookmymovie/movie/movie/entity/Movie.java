package com.cg.bookmymovie.movie.movie.entity;

import java.time.LocalDate;
import java.util.List;


public class Movie {
	private Integer movieId;
	private String movieName;
	private String director;
	private String description;
	private RunningTime runtime;
	private LocalDate releaseDate;
	private List<Cast> Cast;
	private List<Crew> Crew;

	public Movie() {
		super();
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RunningTime getRuntime() {
		return runtime;
	}

	public void setRuntime(RunningTime runtime) {
		this.runtime = runtime;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Cast> getCast() {
		return Cast;
	}

	public void setCast(List<Cast> cast) {
		Cast = cast;
	}

	public List<Crew> getCrew() {
		return Crew;
	}

	public void setCrew(List<Crew> crew) {
		Crew = crew;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", director=" + director + ", description="
				+ description + ", runtime=" + runtime + ", releaseDate=" + releaseDate + ", Cast=" + Cast + ", Crew="
				+ Crew + "]";
	}

	public Movie(Integer movieId, String movieName, String director, String description, RunningTime runtime,
			LocalDate releaseDate, List<com.cg.bookmymovie.movie.movie.entity.Cast> cast,
			List<com.cg.bookmymovie.movie.movie.entity.Crew> crew) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.director = director;
		this.description = description;
		this.runtime = runtime;
		this.releaseDate = releaseDate;
		Cast = cast;
		Crew = crew;
	}

}
