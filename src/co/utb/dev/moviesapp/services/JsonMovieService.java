package co.utb.dev.moviesapp.services;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.utb.dev.moviesapp.entities.Movie;

public class JsonMovieService implements MovieService {

    private String filePath;
    private ObjectMapper mapper;
    private Map<String, Movie> records;

    public JsonMovieService(String filePath) throws Exception {
        this.filePath = filePath;
        this.init();
    }

    private void init() throws Exception {
        // String recordsString = Files.readString(Paths.get(this.filePath),
        // StandardCharsets.UTF_8);
        this.mapper = new ObjectMapper();
        this.records = this.mapper.readValue(new File(this.filePath), new TypeReference<Map<String, Movie>>() {
        });
        System.out.println(this.records);
    }

    @Override
    public boolean saveMovie(Movie movie) {
        this.records.put(movie.getTitle(), movie);
        try {
            this.mapper.writeValue(new File(this.filePath), this.records);

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<Movie>(this.records.values());
    }
    
}
