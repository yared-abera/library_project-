public class Student extends Person {
    private String classroom;

    public Student(int id,String name,int age,String classroom , boolean parentPermission ) {
        super(id, age ,parentPermission,name );
        this.classroom = classroom;
    }

    // Getter and setter methods for classroom
    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }


    // Method to add student to a classroom
    public void addStudent(Classroom classroom) {
        if (!classroom.getStudents().contains(this)) {
            classroom.addStudent(this);
        }
    }
}