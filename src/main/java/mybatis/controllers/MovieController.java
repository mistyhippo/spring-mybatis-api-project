package mybatis.controllers;

import mybatis.model.Movie;
import mybatis.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    // Get all active movies
    @RequestMapping("/")
    public ArrayList<Movie> getMovie() {
        return movieService.getAllMovies();
    }

    // Create New Movie
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Movie addNew(@RequestBody Movie movie) {
        return movieService.addNew(movie);
    }

    // Select Movie
    @RequestMapping(method= RequestMethod.GET, value = "/{id}")
    public Movie getById(@PathVariable(value="id")Integer id) {
        return movieService.getById(id);
    }
    // Update Movie
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    public Movie updateById(@RequestBody Movie movie) {
        return movieService.updateById(movie);
    }

    // Delete Movie (set isActive = false)
    @RequestMapping(method= RequestMethod.DELETE, value="/{id}")
    public Movie deleteById(@PathVariable(value="id") Integer id){
        return movieService.deleteById(id);
    }


}
