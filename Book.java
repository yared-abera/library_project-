public class Book {
    // Title of the book
    String title;

    // Author of the book
    String author;

    // Constructor to initialize the book with a title and an author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getter for the title of the book
    public String getTitle() {
        return title;
    }

    // Setter for the title of the book
    public void setTitle(String title) {
        this.title = title;
    }



    // Getter for the author of the book
    public String getAuthor() {
        return author;
    }

    // Setter for the author of the book
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to add a rental for the book (empty implementation for now)
    public void addRental(Rental rental) {
        // Implementation for adding rentals can be added here if needed

    }
}