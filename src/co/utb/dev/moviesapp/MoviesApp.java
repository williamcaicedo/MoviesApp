package co.utb.dev.moviesapp;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import co.utb.dev.moviesapp.entities.Movie;
import co.utb.dev.moviesapp.services.FileMovieService;
import co.utb.dev.moviesapp.services.MovieService;

public class MoviesApp {

    public static void main(String[] args) throws Exception{
        //Instanciar un objeto que nos permite leer del teclado
        Scanner keyboard = new Scanner(System.in);
        //Pedir los datos de la película
        System.out.println("What's the movie title?");
        String title = keyboard.nextLine();

        System.out.println("What's the movie release date (yyyy-mm-dd)?");
        String releaseDateString = keyboard.nextLine();
        Date releaseDate = new SimpleDateFormat("yyyy-mm-dd").parse(releaseDateString);

        System.out.println("What's the movie director?");
        String director = keyboard.nextLine();

        System.out.println("What's the movie rating (1-5)?");
        int rating = keyboard.nextInt();
        //Cerrar el flujo de entrada
        keyboard.close();
        //Instanciar el objeto película correspondiente
        Movie movie = new Movie(title, releaseDate, director, rating);
        System.out.println(movie.toString());
        //Guardar la información de la película en un archivo
        MovieService movieService = new FileMovieService("src/co/utb/dev/moviesapp/resources/movies.data");
        boolean success = movieService.saveMovie(movie);
        if (success) {
            System.out.println("Success!");
        }
    }
    
}
