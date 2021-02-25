package co.utb.dev.moviesapp.gui;

import javax.swing.SwingUtilities;

public class MoviesApp implements Runnable {

    @Override
    public void run() {

        new MainWindow().setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MoviesApp());
    }
    
}
