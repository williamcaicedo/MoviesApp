package co.utb.dev.moviesapp.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import co.utb.dev.moviesapp.entities.Movie;

public class FileMovieService implements MovieService {

    private String savePath;

    public FileMovieService(String savePath) {
        this.savePath = savePath;
    }

    private BufferedWriter openFile() throws Exception {
        FileWriter f = new FileWriter(this.savePath, true);
        BufferedWriter bw = new BufferedWriter(f);
        return bw;
    }

    @Override
    public boolean saveMovie(Movie movie) {
        try (BufferedWriter bw = this.openFile();) {
            bw.write(movie.toString());
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println("An error has occured while saving a movie - " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Movie> getAllMovies() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
