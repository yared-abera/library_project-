import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        App app = new App();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. List all books");
            System.out.println("2. List all people");
            System.out.println("3. Create a person");
            System.out.println("4. Create a book");
            System.out.println("5. Create a rental");
            System.out.println("6. List rentals for a person");
            System.out.println("7. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    app.listAllBooks();
                    break;
                case 2:
                    app.listAllPeople();
                    break;
                case 3:
                    app.createPerson();
                    break;
                case 4:
                    app.createBook();
                    break;
                case 5:
                    app.createRental();
                    break;
                case 6:
                    System.out.print("Enter the person ID: ");
                    int personId = scanner.nextInt();
                    app.listRentalsForPerson(personId);
                    break;
                case 7:
                    System.out.println("Exiting the application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // Add a newline for better readability
        }
    }
}import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        App app = new App();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. List all books");
            System.out.println("2. List all people");
            System.out.println("3. Create a person");
            System.out.println("4. Create a book");
            System.out.println("5. Create a rental");
            System.out.println("6. List rentals for a person");
            System.out.println("7. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    app.listAllBooks();
                    break;
                case 2:
                    app.listAllPeople();
                    break;
                case 3:
                    app.createPerson();
                    break;
                case 4:
                    app.createBook();
                    break;
                case 5:
                    app.createRental();
                    break;
                case 6:
                    System.out.print("Enter the person ID: ");
                    int personId = scanner.nextInt();
                    app.listRentalsForPerson(personId);
                    break;
                case 7:
                    System.out.println("Exiting the application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // Add a newline for better readability
        }
    }
}