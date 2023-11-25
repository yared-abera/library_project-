import java.util.*;

public class App {
    private static List<Book> books = new ArrayList<>();
    private static List<Person> people = new ArrayList<>();
    private static List<Rental> rentals = new ArrayList<>();
    private static int nextPersonId = 1;

    public static void listAllBooks() {
        System.out.println("Books:");
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    public static void listAllPeople() {
        System.out.println("People:");
        for (Person person : people) {
            System.out.println(person.getName() + " (ID: " + person.getId() + ")");
        }
    }
    public static void createPerson(boolean isTeacher) {
        Scanner scanner = new Scanner(System.in);
        int id = nextPersonId++;
        Person person = null;

        while (person == null) {
            if (isTeacher) {
                System.out.print("Enter the name of the teacher: ");
            } else {
                System.out.print("Enter the name of the student: ");
            }
            String name = scanner.nextLine();

            if (isTeacher) {
                System.out.print("Enter specialization: ");
                String sp = scanner.nextLine();
                System.out.print("Enter age of the teacher: ");
                int age = getIntInput(scanner);
                System.out.print("Enter parentPermission : ");
                boolean parentPermission = getBooleanInput(scanner);
                person = new Teacher(id, age, parentPermission, sp, name);
            } else {
                System.out.print("Enter student's classroom: ");
                String classroom = scanner.nextLine();
                System.out.print("Enter age of the student: ");
                int age = getIntInput(scanner);
                System.out.print("Enter parentPermission : ");
                boolean parentPermission = getBooleanInput(scanner);
                person = new Student(id, age, parentPermission, classroom, name);
            }

            if (person == null) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        people.add(person);
        System.out.println((isTeacher ? "Teacher" : "Student") + " created successfully. ID: " + id);
    }

    private static int getIntInput(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine(); // consume the invalid input
            return getIntInput(scanner); // retry getting input
        }
    }

    private static boolean getBooleanInput(Scanner scanner) {
        try {
            return scanner.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter true or false.");
            scanner.nextLine(); // consume the invalid input
            return getBooleanInput(scanner); // retry getting input
        }
    }

    public static void createBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author= scanner.nextLine();
        Book book = new Book(title,author);
        books.add(book);
        System.out.println("Book created successfully.");
    }

    public static void createRental() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the person ID: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the book title: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Enter the Date: ");
        String  Date = scanner.nextLine();

        Person person = findPersonById(personId);
        Book book = findBookByTitle(bookTitle);

        if (person == null) {
            System.out.println("Person with ID " + personId + " not found.");
            return;
        }

        if (book == null) {
            System.out.println("Book with title " + bookTitle + " not found.");
            return;
        }

        Rental rental = new Rental( Date,book,person);
        rentals.add(rental);
        System.out.println("Rental created successfully.");
    }

    public static void listRentalsForPerson(int personId) {
        Person person = findPersonById(personId);
        if (person == null) {
            System.out.println("Person with ID " + personId + " not found.");
            return;
        }

        System.out.println("Rentals for " + person.getName() + ":");
        for (Rental rental : rentals) {
            if (rental.getPerson().getId() == personId) {
                System.out.println(rental.getBook().getTitle());
            }
        }
    }

    private static Person findPersonById(int personId) {
        for (Person person : people) {
            if (person.getId() == personId) {
                return person;
            }
        }
        return null;
    }

    private static Book findBookByTitle(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }
}