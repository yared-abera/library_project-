public class Person implements Nameable {
    int id;
    String name="unknown";
    int age;
    boolean parentPermission=true;

    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }


    public Person(int age, boolean parentPermission, String name) {
        this.age = age;
        this.parentPermission = parentPermission;
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

    private boolean ofAge() {
        return age >= 18;
    }

    public boolean canUseServices() {
        return ofAge() || parentPermission;
    }

    @Override
    public String correctName() {
        return name;
    }
}
