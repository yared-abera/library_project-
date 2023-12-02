import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static List<Book> books = new ArrayList<>();
    private static List<Person> people = new ArrayList<>();
    private static List<Rental> rentals = new ArrayList<>();
    private static int nextPersonId = 1;
    private MainGUI gui;



    public App() {
        this.gui = gui;
    }

    public void listAllBooks() {
        StringBuilder booksList = new StringBuilder("Books:\n");
        for (Book book : books) {
            booksList.append("BOOK_TITLE  ").append(book.getTitle()).append("\n").append("AUTHOR  ").append( book.getAuthor() );
        }
        showMessage(booksList.toString());
    }

    public void listAllPeople() {
        StringBuilder peopleList = new StringBuilder("People:\n");
        for (Person person : people) {
            peopleList.append(String.format("ID: %d%nNAME: %s%nAGE: %d%n", person.getId(), person.correctName(), person.getAge()));
        }
        showMessage(peopleList.toString());
    }

    public void createPerson() {
        int id = nextPersonId++;
        String name = getNameFromUser();
        int age = getAgeFromUser();
        boolean parentPermission = getParentPermissionFromUser();

        String personType = getPersonTypeFromUser();
        if (personType.equalsIgnoreCase("teacher")) {
            createTeacher(id, name, age, parentPermission);
        } else if (personType.equalsIgnoreCase("student")) {
            createStudent(id, name, age, parentPermission);
        } else {
            showMessage("Invalid person type.");
        }
    }

    private String getNameFromUser() {
        return JOptionPane.showInputDialog(gui, "Enter person's name:");
    }

    private int getAgeFromUser() {
        return Integer.parseInt(JOptionPane.showInputDialog(gui, "Enter person's age:"));
    }

    private boolean getParentPermissionFromUser() {
        return Boolean.parseBoolean(JOptionPane.showInputDialog(gui, "Does the person have parent permission? (true/false):"));
    }

    private String getPersonTypeFromUser() {
        return JOptionPane.showInputDialog(gui, "Is the person a teacher or student? (teacher/student):");
    }


    private void createTeacher(int id, String name, int age, boolean parentPermission) {
        String specialization = JOptionPane.showInputDialog(gui, "Enter teacher's specialization:");
        Teacher teacher = new Teacher(id, age, parentPermission, specialization, name);
        people.add(teacher);
        showMessage("Teacher created successfully.");
    }
    private void createStudent(int id, String name, int age, boolean parentPermission) {
        String classroomLabel = JOptionPane.showInputDialog(null, "Enter student's classroom:");
        Student student =new Student( id,name,age,classroomLabel, parentPermission );
        people.add(student);
        showMessage("student created successfully.");}


    public void createBook() {
        String title = JOptionPane.showInputDialog(gui, "Enter the title of the book:");
        String author = JOptionPane.showInputDialog(gui, "Enter the author of the book:");
        Book book = new Book(title, author);
        books.add(book);
        showMessage("Book created successfully.");
    }

    public void createRental() {
        int personId = Integer.parseInt(JOptionPane.showInputDialog(gui, "Enter the person ID:"));
        String bookTitle = JOptionPane.showInputDialog(gui, "Enter the book title:");
        String date = JOptionPane.showInputDialog(gui, "Enter the Date:");

        Person person = findPersonById(personId);
        Book book = findBookByTitle(bookTitle);

        if (person == null) {
            showMessage("Person with ID " + personId + " not found.");
            return;
        }

        if (book == null) {
            showMessage("Book with title " + bookTitle + " not found.");
            return;
        }

        Rental rental = new Rental(date, book, person);
        rentals.add(rental);
        showMessage("Rental created successfully.");
    }

    public void listRentalsForPerson(int personId) {
        Person person = findPersonById(personId);
        if (person == null) {
            showMessage("Person with ID " + personId + " not found.");
            return;
        }

        StringBuilder rentalsList = new StringBuilder("Rentals for " + person.correctName() + ":\n");
        for (Rental rental : rentals) {
            if (rental.getPerson().getId() == personId) {
                rentalsList.append("BOOK_TITLE: ").append(rental.getBook().getTitle()).append("\n");
            }
        }
        showMessage(rentalsList.toString());
    }

    private Person findPersonById(int personId) {
        for (Person person : people) {
            if (person.getId() == personId) {
                return person;
            }
        }
        return null;
    }

    private Book findBookByTitle(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(gui, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI mainGUI = new MainGUI();
            App app = new App();
            mainGUI.setAppInstance(app); // Assuming you have a method setAppInstance in MainGUI
            mainGUI.setVisible(true);
        });
    }}
