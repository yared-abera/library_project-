import java.util.ArrayList;
import java.util.List;


public class Classroom {
    // Label for the classroom
    String label;

    // List of students in the classroom
    List<Student> students = new ArrayList<>();

    // Constructor to initialize the classroom with a label
    public Classroom(String label) {
        this.label = label;
    }

    // Getter for the label of the classroom
    public String getLabel() {
        return label;
    }

    // Setter for the label of the classroom
    public void setLabel(String label) {
        this.label = label;
    }

    // Getter for the list of students in the classroom
    public List<Student> getStudents() {
        return students;
    }

    // Method to add a student to the classroom
    public void addStudent(Student student) {
        students.add(student);
        // Set the classroom for the student
        student.setClassroom(this);
    }
}