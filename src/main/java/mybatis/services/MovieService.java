package mybatis.services;

import mybatis.mappers.MovieMapper;
import mybatis.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {

    @Autowired
    MovieMapper mapper;



    //get all users using mybatis
    public ArrayList<Movie> getAllMovies (){
        return mapper.getAlls();
    }

    //get user by id
    public Movie getById(int id){
        return mapper.getByID(id);
    }

    //add new movie
    public Movie addNew(Movie m ) {
        mapper.insert(m);
        return mapper.getByName(m.getName());
    }

    //update movie by its id
    public Movie updateById( Movie m) {
        mapper.update(m);
        return mapper.getByName(m.getName());
    }

    //delete
    public Movie deleteById(int id) {
        mapper.delete(id);
        return mapper.getByID(id);
    }
}
