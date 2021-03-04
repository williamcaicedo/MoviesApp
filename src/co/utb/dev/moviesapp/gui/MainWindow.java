package co.utb.dev.moviesapp.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import co.utb.dev.moviesapp.entities.Movie;
import co.utb.dev.moviesapp.services.MovieService;

public class MainWindow extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private JTextField movieName;
    private JTextField directorName;
    private SpinnerNumberModel yearModel;
    private SpinnerNumberModel monthModel;
    private SpinnerNumberModel dayModel;
    private SpinnerNumberModel ratingModel;

    private final MovieService movieService;



    

    public MainWindow(MovieService movieService) {
        this.movieService = movieService;
        this.init();
        this.setWindowListener();
    }

    private void init() {
        this.setTitle("The Movies App");
        this.setSize(500, 200);
        JButton button = new JButton("Save");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String movieName = MainWindow.this.movieName.getText();
                String directorName = MainWindow.this.directorName.getText();
                int movieRating = (Integer)MainWindow.this.ratingModel.getValue();
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, (Integer)MainWindow.this.yearModel.getValue());
                cal.set(Calendar.MONTH, (Integer)MainWindow.this.monthModel.getValue());
                cal.set(Calendar.DAY_OF_MONTH, (Integer)MainWindow.this.dayModel.getValue());
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                Date releaseDate = cal.getTime();


                Movie movie = new Movie(movieName, releaseDate, directorName, movieRating);
                boolean success = MainWindow.this.movieService.saveMovie(movie);
                if (success)
                    JOptionPane.showMessageDialog(MainWindow.this, "Movie has been saved!");

            }
            
        });

        movieName = new JTextField();
        movieName.setColumns(20);
        JLabel nameLabel = new JLabel("Enter the movie name");

       
        JLabel releaseLabel = new JLabel("Enter the movie release date");

        JPanel datePanel = new JPanel();
        
        yearModel = new SpinnerNumberModel(2021,1982,2021,1);
        JSpinner releaseYear = new JSpinner();
        releaseYear.setModel(yearModel);

        monthModel = new SpinnerNumberModel(1,1,12,1);
        JSpinner releaseMonth = new JSpinner();
        releaseMonth.setModel(monthModel);

        dayModel = new SpinnerNumberModel(1,1,31,1);
        JSpinner releaseDay = new JSpinner();
        releaseDay.setModel(dayModel);

        datePanel.add(releaseYear);
        datePanel.add(releaseMonth);
        datePanel.add(releaseDay);
        

        directorName = new JTextField();
        directorName.setColumns(20);
        JLabel directorLabel = new JLabel("Enter the director's name");

        ratingModel = new SpinnerNumberModel(5,1,5,1);
        JSpinner movieRating = new JSpinner();
        movieRating.setModel(ratingModel);
        JLabel ratingLabel = new JLabel("Enter the movie rating");

        JPanel mainPanel = new JPanel();

        GridLayout layout = new GridLayout(5, 2, 5, 2);
        mainPanel.setLayout(layout);
        
        mainPanel.add(nameLabel);
        mainPanel.add(movieName);

        mainPanel.add(directorLabel);
        mainPanel.add(directorName);

        mainPanel.add(releaseLabel);
        mainPanel.add(datePanel);

        mainPanel.add(ratingLabel);
        mainPanel.add(movieRating);

        mainPanel.add(new JPanel());
        mainPanel.add(button);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.getContentPane().add(mainPanel);
    }

    private void setWindowListener() {
        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }
            
        });
    }


    
}
