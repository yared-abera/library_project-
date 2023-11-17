public class Main {
    public static void main(String[] args) {
        // Create a person
          Person person = new Person(22,"maximilianus");
          System.out.println(person.correctName());

        // Apply  the capitalize decorator
        CapitalizeDecorator capitalizedPerson = new CapitalizeDecorator(person);
        System.out.println(capitalizedPerson.correctName());

        // Apply the  trimmer decorator
        TrimmerDecorator capitalizedTrimmedPerson = new TrimmerDecorator(capitalizedPerson);
        System.out.println(capitalizedTrimmedPerson.correctName());
    }
}
