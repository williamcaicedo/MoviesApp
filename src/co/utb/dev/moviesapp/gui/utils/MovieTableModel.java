package co.utb.dev.moviesapp.gui.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

import co.utb.dev.moviesapp.entities.Movie;

public class MovieTableModel extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String[] colummNames = new String[] { "Title", "Director", "Release Date", "Rating" };
    private List<Object[]> movieData;

    public MovieTableModel(List<Movie> movies, String[] columnNames) {
        this.updateMoviesData(movies, false);
        this.colummNames = columnNames;
    }

    @Override
    public int getRowCount() {
        return this.movieData.size();
    }

    @Override
    public int getColumnCount() {
        return this.colummNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.movieData.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return this.colummNames[column];
    }

    public void updateMoviesData(List<Movie> movies, boolean append) {
        if (!append) {
            this.movieData = new ArrayList<>();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.movieData.addAll(movies.stream()
                .map(m -> new Object[] { m.getTitle(), m.getDirector(), format.format(m.getReleaseDate()), m.getRating() })
                .collect(Collectors.toList()));
        
        this.fireTableDataChanged();
    }

}
