public class Person {

     int id;
     String name="unknown";
     int age;
      boolean parent_permission=true;


    public Person(int age, boolean parent_permission ,String name) {
        this.age = age;
        this.parent_permission=parent_permission;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void setName(String name) {

            this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    private boolean of_age() {
        return age >= 18;
    }


    public boolean can_use_services() {
        return of_age() || parent_permission;
    }
}
