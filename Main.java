import javax.swing.*;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private App app = new App();
    //private App app;

    public void setAppInstance(App appInstance) {
        this.app = appInstance;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI mainGUI = new MainGUI();
            mainGUI.setVisible(true);
        });
    }

    public MainGUI() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(createButton("List All Books", e -> app.listAllBooks()));
        panel.add(createButton("List All People", e -> app.listAllPeople()));
        panel.add(createButton("Create Person", e -> app.createPerson()));
        panel.add(createButton("Create Book", e -> app.createBook()));
        panel.add(createButton("Create Rental", e -> app.createRental()));
        panel.add(createButton("List Rentals for a Person", e -> {
            int personId = getUserInput("Enter the person ID: ");
            app.listRentalsForPerson(personId);
        }));
        panel.add(createButton("Quit", e -> System.exit(0)));

        add(panel);
    }


}