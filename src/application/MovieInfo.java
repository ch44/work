package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MovieInfo {
	private final StringProperty title;
	private final StringProperty genre;
	private final StringProperty year;
	private final StringProperty rating;

	public MovieInfo(String title, String genre, String year, String rating) {
		this.title = new SimpleStringProperty(title);
		this.genre = new SimpleStringProperty(genre);
		this.year = new SimpleStringProperty(year);
		this.rating = new SimpleStringProperty(rating);
	}
	
	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}
	
	public StringProperty titleProperty() {
		return title;
	}

	public String getGenre() {
		return genre.get();
	}

	public void setGenre(String genre) {
		this.genre.set(genre);
	}
	
	public StringProperty genreProperty() {
		return genre;
	}
	
	public String getYear() {
		return year.get();
	}

	public void setYear(String year) {
		this.year.set(year);
	}
	
	public StringProperty yearProperty() {
		return year;
	}
	
	public String getRating() {
		return rating.get();
	}

	public void setRating(String rating) {
		this.rating.set(rating);
	}
	
	public StringProperty ratingProperty() {
		return title;
	}
	
//	private long movieID;
//	private String Title;
//	private int Year;
//	private String Genre;
//	private double Rating;
//	public long getMovieID() {
//		return movieID;
//	}
//	public void setMovieID(long movieID) {
//		this.movieID = movieID;
//	}
//	public String getTitle() {
//		return Title;
//	}
//	public void setTitle(String title) {
//		Title = title;
//	}
//	public int getYear() {
//		return Year;
//	}
//	public void setYear(int year) {
//		Year = year;
//	}
//	public String getGenre() {
//		return Genre;
//	}
//	public void setGenre(String genre) {
//		Genre = genre;
//	}
//	public double getRating() {
//		return Rating;
//	}
//	public void setRating(double rating) {
//		Rating = rating;
//	}

	
	
}
