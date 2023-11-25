public class Student extends Person {
     Classroom classroom;

    public Student(int id,int age, boolean parentPermission, String classroom, String name) {
        super(id,age, parentPermission, name);
           this.classroom = new Classroom(classroom);
           this.classroom.addStudent(this);
    }

     public Classroom getClassroom() {
        return classroom;
    }

      public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
        classroom.addStudent(this);
    }
}