public class Show {

  // Attributes
  private String Title, Genre;
  private int year;
  private double rating;
  private static int showCounter = 0;

  // Constructor 4 Attributes
  public Show(String Title, String Genre, int year, double rating) {
    this.Genre = Genre;
    this.Title = Title;
    this.year = year;
    this.rating = rating;
    showCounter++;
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
  public static int findNumberOfCreatedShows() {
    return showCounter;
  }

  @Override
  public boolean equals(Object obj) {
    Show temp = (Show) obj;

    String t1 = this.Title.replace(" ", "");
    t1 = t1.toLowerCase();

    String t2 = temp.Title.replace(" ", "");
    t2 = t2.toLowerCase();

    return this.year == temp.year && t1.equals(t2);

  }

  @Override
  public String toString() {
    return ("Title: " + this.Title +
        "\nyear: " + this.year +
        "\nGenre: " + this.Genre +
        "\nrating: " + this.rating);
  }

}
