import java.util.Scanner;

public class Driver {
  final static String PASSWORD = "STREAM";

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Welcome to the Streaming Service Catalog Manager!");
    System.out.print("\nPlease enter maximum number of shows: ");

    int maxShows = in.nextInt();
    in.nextLine();
    Show[] catalog = new Show[maxShows]; // creates show array

    int consecutiveMenuFailures = 0; // counts failed password cycles
    boolean running = true;

    while (running) {
      System.out.println("\nWhat do you want to do?");
      System.out.println("1. Enter new Shows (password required)");
      System.out.println("2. Change information of a Show (password required)");
      System.out.println("3. Display all Shows of a specific genre");
      System.out.println("4. Display all Shows with a rating above a certain value.");
      System.out.println("5. Quit.");
      System.out.print("Please enter your choice: ");

      int choice = in.nextInt();
      in.nextLine();

      switch (choice) {
        case 1:
          boolean authorized = false;

          // Allow 3 password attempts
          for (int i = 0; i < 3; i++) {
            System.out.print("Enter password: ");
            String tempPW = in.nextLine();

            if (tempPW.equals(PASSWORD)) { // Correct password
              authorized = true;
              break;
            } else {
              System.out.println("Incorrect password. Try again.");// Incorrect password

            }
          }

          if (!authorized) {
            consecutiveMenuFailures++;
            System.out.println("Authentication failed. Returning to main menu.");

            if (consecutiveMenuFailures >= 3) { // 3 failed cycles = 9 total attempts
              System.out.println(
                  "Program detected suspicious activities and will terminate immediately!");
              running = false; // terminates Program due to 9 total failed attempts
            }
            break;
          }

          System.out.println("Access granted.");

          // Count remaining space
          int remainingSpace = 0;
          for (int i = 0; i < maxShows; i++) {
            if (catalog[i] == null)
              remainingSpace++;
          }

          System.out.print("How many shows would you like to enter? ");
          int numShows = in.nextInt();
          in.nextLine();

          if (numShows > remainingSpace) { // Checking remainingSpace in array
            System.out.println(
                "Not enough space in catalog. Only " + remainingSpace + " slots available.");
            break;
          }

          // Insert shows into next available slots
          for (int n = 0; n < numShows; n++) {
            System.out.println("Entering show number " + n + ": ");
            System.out.print("Enter title of show: ");
            String Title = in.nextLine();

            System.out.print("Enter genre of show: ");
            String Genre = in.nextLine();

            System.out.print("Enter rating of show: ");
            double rating = in.nextDouble();

            System.out.print("Enter release year of show: ");
            int year = in.nextInt();
            in.nextLine();

            // find next empty slot
            for (int i = 0; i < maxShows; i++) {
              if (catalog[i] == null) {
                catalog[i] = new Show(Title, Genre, year, rating);
                break;
              }
            }

          }
          break;

        case 2:
          boolean authorized2 = false;

          // Allow 3 password attempts
          for (int i = 0; i < 3; i++) {
            System.out.print("Enter password: ");
            String tempPW = in.nextLine();

            if (tempPW.equals(PASSWORD)) {
              authorized2 = true;
              break;
            } else {
              System.out.println("Incorrect password. Try again.");
            }
          }
          if (!authorized2) {
            System.out.println("Authentication failed. Returning to main menu.");
            break; // Exits to main menu

          }
          int menuChoice2 = 0;
          int updateChoice = 0;
          while (true) {
            System.out.println("Which show number would you like to update: (show number 1 is index 0)");
            updateChoice = in.nextInt();
            if (catalog[updateChoice] == null) { // Checking if index is empty
              System.out.print("Show number does not exist. 1) Re-enter 2) Quit: ");
              menuChoice2 = in.nextInt();
              in.nextLine();
              if (menuChoice2 == 2)
                break; // exit loop
            } else {
              break; // valid index
            }
          }
          if (menuChoice2 == 2) {
            break; // Exits to main menu
          }

          boolean updating = true;

          while (updating) {
            Show s = catalog[updateChoice];
            System.out.println("Show # " + updateChoice); // Display information about show selected
            System.out.println("Title: " + s.getTitle());
            System.out.println("Genre: " + s.getGenre());
            System.out.println("Year: " + s.getYear());
            System.out.println("Rating: " + s.getRating());

            System.out.println("\nWhat information would you like to change?");

            System.out.println("1. Genre");
            System.out.println("2. Title");
            System.out.println("3. Year");
            System.out.println("4. Rating");
            System.out.println("5. Quit");
            System.out.println("Enter your choice: ");

            int menuChoice3 = in.nextInt();
            in.nextLine();

            switch (menuChoice3) {
              case 1: // updating genre
                System.out.print("Enter new genre: ");
                String newGenre = in.nextLine();
                s.setGenre(newGenre);
                break;
              case 2: // updating title
                System.out.print("Enter new title: ");
                String newTitle = in.nextLine();
                s.setTitle(newTitle);
                break;
              case 3: // updating release year
                System.out.print("Enter new release year: ");
                int newYear = in.nextInt();
                in.nextLine();
                s.setYear(newYear);
                break;
              case 4: // updating rating
                System.out.print("Enter new rating: ");
                double newRating = in.nextDouble();
                in.nextLine();
                s.setRating(newRating);
                break;
              case 5: // Quit
                updating = false;
                break;
              default:
                System.out.println("Invalid choice.");
            }

          }
          break;
        case 3:

          System.out.println("Enter Genre you would like to search for: ");
          String requestedGenre = in.nextLine();
          int counter = 0; // counter to check if no show was found

          for (int i = 0; i < catalog.length; i++) {
            if (catalog[i] != null) {
              if (catalog[i].getGenre().equalsIgnoreCase(requestedGenre)) {
                System.out.println(catalog[i].toString());
                counter++;
              }
            }
          }
          if (counter == 0) {
            System.out.println("No show with that genre");
          }

          break;

        case 4:

          System.out.println("Enter rating you would like to filter by: ");
          double requestedRating = in.nextDouble();
          in.nextLine();
          int counter2 = 0; // counter to check if no show was found

          for (int i = 0; i < catalog.length; i++) {
            if (catalog[i] != null) {
              if (catalog[i].getRating() > requestedRating) {
                System.out.println(catalog[i].toString());
                counter2++;
              }
            }
          }
          if (counter2 == 0) {
            System.out.println("No Show has that high a rating.");
          }

          break;
        case 5:
          System.out.println("Thank you for using the Streaming catalog!!!");
          running = false;// terminate Program
          break;
        default:
          System.out.println("Invalid choice.");
      }
    }

    in.close(); // close keyboard Scanner
  }
}
