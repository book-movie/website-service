package com.cg.bookmymovie.websiteService.websiteController;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bookmymovie.movie.movie.entity.Movie;
import com.cg.bookmymovie.screeningservice.entity.Address;
import com.cg.bookmymovie.screeningservice.entity.Screening;
import com.cg.bookmymovie.screeningservice.entity.Seat;

@RestController
@EnableOAuth2Sso
public class WebsiteController {

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	private List<Screening> allTheatres = new ArrayList<Screening>();
	private Set<LocalDate> screeningDatesOfAMovie = new HashSet<LocalDate>();
	private String moviePoster = "";

	@Autowired
	private RestTemplate template;

	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("hello", "message", "shubham bhatt");
	}

	@RequestMapping("/hello")
	public ModelAndView hello() {
		return new ModelAndView("hello", "message", "shubham bhatt");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/cityToSearch")
	public ModelAndView searchMovieInACity(@RequestParam String cityToSearch) {

		/*
		 * because after selecting city and getting theatres showing movieif i go back
		 * and selects some different city and then checks theatre showing movie in that
		 * city. i will get theatres of previous city also because i'm storing that data
		 * in member variable as a list.
		 */
		allTheatres.clear();
		screeningDatesOfAMovie.clear();

		Set<Screening> allMovieShowingInACity = new HashSet<Screening>();

		ResponseEntity<Screening[]> screening = template.getForEntity("http://localhost:9191/screenings",
				Screening[].class);

		List<Screening> allScreenings = Arrays.asList(screening.getBody());

		for (Screening screeningToValidate : allScreenings) {

			Address address = screeningToValidate.getTheatreAddress();

			if (address.getCity().equalsIgnoreCase(cityToSearch)) {
				allMovieShowingInACity.add(screeningToValidate);
				allTheatres.add(screeningToValidate);

				screeningDatesOfAMovie.add(screeningToValidate.getDate()); // setting all dates on which this movie will
																			// be screening in this city
			}
		}
		return new ModelAndView("moviesShowing", "movies", allMovieShowingInACity);
	}

	@RequestMapping("/getMovieDetails")
	public ModelAndView getMovie(@RequestParam String movieName, Model model) {
		System.out.println(movieName);
		Movie movie = template.getForObject("http://localhost:8585/movies/" + movieName, Movie.class);

		for (Screening screening : allTheatres) {
			if (screening.getMovieName().equalsIgnoreCase(movieName)) {
				moviePoster = screening.getMoviePoster(); // it is required for subsequent request also
				model.addAttribute("moviePoster", screening.getMoviePoster());
				break;
			}
		}
		model.addAttribute("movie", movie);
		return new ModelAndView("movieDetail");
	}

	@RequestMapping("/theatreShowingMovie")
	public ModelAndView showTheatres(Model model) {
		LocalDate todaysdate = LocalDate.now();

		List<Screening> theatreShowingMovieToday = new ArrayList<Screening>();

		for (Screening screening : allTheatres) {
			if (todaysdate.equals(screening.getDate()))
				theatreShowingMovieToday.add(screening);
		}

		model.addAttribute("moviePoster", moviePoster);
		model.addAttribute("theatres", theatreShowingMovieToday);
		model.addAttribute("dates", screeningDatesOfAMovie);
		return new ModelAndView("theatres");
	}

	@RequestMapping("/theatreShowingMovieByDate")
	public ModelAndView showTheatresBydate(Model model, @RequestParam String dateAsString) {
		LocalDate date = LocalDate.parse(dateAsString);
		System.out.println(dateAsString);

		List<Screening> theatreShowingMovieOnSpecificDate = new ArrayList<Screening>();
		for (Screening screening : allTheatres) {
			if (date.equals(screening.getDate())) // you are getting all the movies of all cities of todays date that
													// why u got all cities date
				theatreShowingMovieOnSpecificDate.add(screening);
		}

		model.addAttribute("moviePoster", moviePoster);
		model.addAttribute("theatres", theatreShowingMovieOnSpecificDate); // here theatres is a key
		model.addAttribute("dates", screeningDatesOfAMovie);
		return new ModelAndView("theatres"); // here theatres is a jsp page
	}

	@RequestMapping("/chooseSeats")
	public ModelAndView showSeatsOfTheatre(@RequestParam String theatreName, @RequestParam String theatreState,
			@RequestParam String theatreCity, @RequestParam String theatreArea, @RequestParam String date,
			@RequestParam String startTime, Model model) {

		// Map<String,Integer> seats = new HashMap<String,Integer>();

		String[] dateArray = date.split("-");
		int year = Integer.parseInt(dateArray[0]);
		int month = Integer.parseInt(dateArray[1]);
		int day = Integer.parseInt(dateArray[2]);

		String[] timeArray = startTime.split(":");
		Integer hour = Integer.parseInt(timeArray[0]);
		Integer minute = Integer.parseInt(timeArray[1]);

		LocalDate dateIs = LocalDate.of(year, month, day);
		LocalTime timeIs = LocalTime.of(hour, minute);

		System.out.println(dateIs + "  " + timeIs + "  " + allTheatres.size());
		Screening screen = new Screening();
		for (Screening screening : allTheatres) {
			System.out.println(screening.getStartTime());
			System.out.println(screening.getStartTime().equals(timeIs) + " " + screening.getDate().equals(dateIs));
			if (screening.getTheatreName().equals(theatreName)
					&& screening.getTheatreAddress().getState().equals(theatreState)
					&& screening.getTheatreAddress().getCity().equals(theatreCity)
					&& screening.getTheatreAddress().getArea().equals(theatreArea) && screening.getDate().equals(dateIs)
					&& screening.getStartTime().equals(timeIs)) {

				model.addAttribute("screen", screening);
				screen = screening;
				break;
			}
		}

//mapping of seatType with the numberOfSeat of that type available		
		Map<String, Integer> seatTypes = new HashMap<String, Integer>();

//to get different type of seat available		
		Set<String> typesOfSeat = new HashSet<String>();
		for (Map.Entry<Integer, Seat> entry : screen.getSeat().entrySet()) {

			typesOfSeat.add(entry.getValue().getSeatType());
		}
		Object objArray[] = typesOfSeat.toArray();

//to set number of seat available in different type of seats		
		for (int count = 0; count < objArray.length; count++) {
			int seatsAvailable = 0;
			for (Map.Entry<Integer, Seat> entry : screen.getSeat().entrySet()) {
				if (entry.getValue().getSeatType().equals(objArray[count].toString())
						&& entry.getValue().isAvailable() == true)
					seatsAvailable++;
			}
			seatTypes.put(objArray[count].toString(), seatsAvailable);
		}

		model.addAttribute("seatAvailable", seatTypes);
		return new ModelAndView("seats");
	}

}
