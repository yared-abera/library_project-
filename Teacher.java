  public class Teacher extends Person {
     String specialization;


    public Teacher(int age, boolean parentPermission, String specialization, String name) {
        super(age, parentPermission, name);
        this.specialization = specialization;
    }


    public boolean can_use_services() {

        return true;
    }
}
