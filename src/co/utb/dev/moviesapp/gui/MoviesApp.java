package co.utb.dev.moviesapp.gui;

import javax.swing.SwingUtilities;

import co.utb.dev.moviesapp.services.JsonMovieService;

public class MoviesApp implements Runnable {

    @Override
    public void run() {

        try {
            new MainWindow(new JsonMovieService("src/co/utb/dev/moviesapp/resources/movies.json")).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MoviesApp());
    }
    
}
