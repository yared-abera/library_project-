import java.util.ArrayList;
import java.util.List;


public class Person implements Nameable {
    // Unique identifier for the person
    int id;

    public String getName() {
        return name;
    }

    // Name of the person (defaulted to "unknown" if not provided)
    String name = "unknown";

    // Age of the person
    int age;

    // Indicates whether the person has parental permission
    boolean parentPermission = true;

    // List to store rentals associated with the person
   List<Rental> rentals = new ArrayList<>();

    // Constructor to initialize a person with age, parental permission, and name
    public Person(int id,int age, boolean parentPermission, String name) {
        this.id=id;
        this.age = age;
        this.parentPermission = parentPermission;
        this.name = name;
    }

    public Person(int age, String maximilianus) {

    }

    // Getter for the unique identifier of the person
    public int getId() {
        return id;
    }

    // Getter for the age of the person
    public int getAge() {
        return age;
    }

    // Setter for the name of the person
    public void setName(String name) {
        this.name = name;
    }

    // Setter for the age of the person
    public void setAge(int age) {
        this.age = age;
    }

    // Private method to check if the person is of age (18 or older)
    private boolean ofAge() {
        return age >= 18;
    }

    // Method to check if the person can use services (e.g., rent a book)
    public boolean canUseServices() {
        return ofAge() || parentPermission;
    }

    // Alternative method name for canUseServices
    public boolean can_use_services() {
        return ofAge() || parentPermission;
    }

    // Implementation of the correctName method from the Nameable interface

    public String correctName() {
        return name;
    }

    // Method to add a rental associated with the person
    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    // Method to get the list of rentals associated with the person
    public List<Rental> getRentals() {
        return rentals;
    }
}
