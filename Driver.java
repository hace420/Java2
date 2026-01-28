import java.util.Scanner;

public class Driver {
  final static String PASSWORD = "STREAM";

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Welcome to the Streaming Service Catalog Manager!");
    System.out.print("\nPlease enter maximum number of shows: ");

    int maxShows = in.nextInt();
    in.nextLine();
    Show[] catalog = new Show[maxShows];

    System.out.println("What do you want to do?");
    System.out.println("1. Enter new Shows (password required)");
    System.out.println("2. Change information of a Show (password required)");
    System.out.println("3. Display all Shows of a specific genre");
    System.out.println("4. Display all Shows with a rating above a certain value.");
    System.out.println("5. Quit.");
    System.out.println("Please enter your choice: ");

    int choice = 0;

    switch (choice) {
      case 1:

        boolean authorized = false;

        for (int i = 0; i < 3; i++) {
          System.out.println("Enter password: ");
          String tempPW = in.next();

          if (tempPW.equals(PASSWORD)) {
            authorized = true;
            break;
          } else {
            System.out.println("\nPlease try again.");
          }

        }
        if (!authorized) {
          System.out.println("\nAuthentication failed returning to main menu.");
        } else {
          System.out.println("\n Acess granted!");
          System.out.println("\nEnter title of show: ");
          String title = in.next();
          System.out.println("\nEnter Genre of show: ");
          String Genre = in.next();
          System.out.println("\nEnter rating of show: ");
          double rating = in.nextDouble();
          System.out.println("\nEnter release year of show: ");
          int year = in.nextInt();

        }
        break;
    }

    in.close();
  }
}
