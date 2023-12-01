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
            System.out.printf("ID: %d%n", person.getId());
            System.out.printf("NAME: %s%n", person.getName());
            System.out.printf("AGE: %d%n", person.getAge());
        }
    }
    public static void createPerson() {
        Scanner scanner = new Scanner(System.in);
        int id = nextPersonId++;
        System.out.print("Enter person's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter person's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Does the person have parent permission? (true/false): ");
        boolean parentPermission = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Is the person a teacher or student? (teacher/student): ");
        String personType = scanner.nextLine();

        if (personType.equalsIgnoreCase("teacher")) {
            System.out.print("Enter teacher's specialization: ");
            String specialization = scanner.nextLine();
            Teacher teacher = new Teacher(id,age, parentPermission, specialization,name );
            people.add(teacher);
            System.out.println("Teacher created successfully.");
        } else if (personType.equalsIgnoreCase("student")) {
            Student student = new Student(id ,age, parentPermission,name);
            people.add(student);
            System.out.println("Student created successfully.");
        } else {
            System.out.println("Invalid person type.");
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