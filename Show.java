public class Show {

  // Attributes
  private String Title, Genre;
  private int year;
  private double rating;
  private int showCounter = 0;

  // Constructor 4 Attributes
  public Show(String Title, String Genre, int year, double rating) {
    this.Genre = Genre;
    this.Title = Title;
    this.year = year;
    this.rating = rating;
    showCounter = showCounter + 1;
  }

  // Mutators
  public void setTitle(String Title) {
    this.Title = Title;

  }

  public void setGenre(String Genre) {
    this.Genre = Genre;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  // Accessors
  public String getTitle() {
    return this.Title;
  }

  public String getGenre() {
    return this.Genre;
  }

  public int getYear() {
    return this.year;
  }

  public double getRating() {
    return this.rating;
  }

  // method that returns number of shows created
  public int findNumberOfCreatedShows() {
    return showCounter;
  }

}
