public class Student extends Person {
      String classroom;


    public Student(int age, boolean parentPermission, String classroom, String name) {
        super(age, parentPermission, name);
        this.classroom = classroom;
    }
}
