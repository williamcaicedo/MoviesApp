package co.utb.dev.moviesapp.gui;

import javax.swing.SwingUtilities;

import co.utb.dev.moviesapp.services.FileMovieService;

public class MoviesApp implements Runnable {

    @Override
    public void run() {

        new MainWindow(new FileMovieService("src/co/utb/dev/moviesapp/resources/movies.data")).setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MoviesApp());
    }
    
}
