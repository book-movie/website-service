package com.cg.bookmymovie.websiteService.websiteController;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

@RestController
@EnableOAuth2Sso
public class WebsiteController {

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	private List<Screening> allTheatres = new ArrayList<Screening>();
	private Set<LocalDate> screeningDatesOfAMovie = new HashSet<LocalDate>();
	private String moviePoster="";
	
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

/*because after selecting city and getting theatres showing movieif i go back and selects some different city and then checks 
theatre showing movie in that city. i will get theatres of previous city also because i'm storing that data in member variable as a list.
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
				
				screeningDatesOfAMovie.add(screeningToValidate.getDate());			//setting all dates on which this movie will be screening in this city
			}
		}
		return new ModelAndView("moviesShowing", "movies", allMovieShowingInACity);
	}

	@RequestMapping("/getMovieDetails")
	public ModelAndView getMovie(@RequestParam String movieName, Model model) {
		System.out.println(movieName);
		Movie movie = template.getForObject("http://localhost:8585/movies/" + movieName, Movie.class);
		
		for(Screening screening: allTheatres ) {
			if(screening.getMovieName().equalsIgnoreCase(movieName)) {
				moviePoster = screening.getMoviePoster();							//it is required for subsequent request also
				model.addAttribute("moviePoster",screening.getMoviePoster());
				break;
			}
		}
		model.addAttribute("movie",movie);
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

		model.addAttribute("moviePoster",moviePoster);
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
			if (date.equals(screening.getDate()))   // you are getting all the movies of all cities of todays date that why u got all cities date
				theatreShowingMovieOnSpecificDate.add(screening);
		}
		
		model.addAttribute("moviePoster",moviePoster);
		model.addAttribute("theatres", theatreShowingMovieOnSpecificDate);		//here theatres is a key
		model.addAttribute("dates", screeningDatesOfAMovie);
		return new ModelAndView("theatres");									//here theatres is a jsp page
	}
	
	@RequestMapping("/chooseSeats")
	public ModelAndView showSeatsOfTheatre(@RequestParam Screening screening) {
		System.out.println("hello"+screening);
		return null;
	}
}
