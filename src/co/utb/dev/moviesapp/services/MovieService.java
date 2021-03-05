package co.utb.dev.moviesapp.services;

import java.util.List;

import co.utb.dev.moviesapp.entities.Movie;

public interface MovieService {
    
    public boolean saveMovie(Movie movie);
    public List<Movie> getAllMovies();
}
