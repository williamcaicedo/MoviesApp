package co.utb.dev.moviesapp.entities;

import java.util.Date;

public class Movie {
    private String title;
    private Date releaseDate;
    private String director;
    private int rating;

    public Movie(){}

    public Movie(String title, Date releaseDate, String director, int rating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return this.title + ", directed by " + this.director + ", was released in " 
        + this.releaseDate + " and I give it a " + this.rating;
    }

    


}
