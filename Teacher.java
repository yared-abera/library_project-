  public class Teacher extends Person {
     String specialization;


    public Teacher(int id,int age, boolean parentPermission, String specialization, String name) {
        super(id,age, parentPermission, name);
        this.specialization = specialization;
    }




    public boolean can_use_services() {

        return true;
    }
}
