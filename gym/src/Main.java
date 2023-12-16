import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the date
        System.out.print("Enter the date (YYYY-MM-DD): ");

        // Read the user input as a string
        String userInput = scanner.nextLine();

        try {
            // Parse the user input string into a LocalDate object
            LocalDate date = LocalDate.parse(userInput);

            // Get and print the month
            int monthValue = date.getMonthValue();
            String monthName = String.valueOf(date.getMonth());
            int yea=date.getYear();

            System.out.println("Month: " + monthName + " (" + monthValue + ")");
            System.out.println("year: " + yea );
        } catch (Exception e) {
            // Handle the case where the user input is not a valid date
            System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
        }
    }
}
