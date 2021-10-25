public class Person {
    private FirstName firstName;
    private LastName lastName;
    private MiddleName middleName;
    private Acting acting;

    public Person(String firstName, String lastName, String middleName, String actingAs) {
        this.firstName = new FirstName(firstName);
        this.lastName = new LastName(lastName);
        this.middleName = new MiddleName(middleName);
        this.acting = new Acting(actingAs);
    }

    public Person(String actingAs) {
        this.firstName = null;
        this.lastName = null;
        this.middleName = null;
        this.actingAs = new Acting(actingAs);
    }

    public static Person fromString(String string) {
        String[] strings = string.split(" Телефон: ");
        String[] nameParts = strings[0].split(" ");
        if (nameParts.length == 3) {
            return new Person(nameParts[0], nameParts[1], nameParts[2], Acting.ABSENT);
        }

        strings = string.split(" Секретар: ");
        return new Person(strings[0]);
    }

    @Override
    public String toString() {
        if (acting.equals("absent")) {
            return String.format("%s, %s, %s", lastName.toString(), firstName.toString(), middleName.toString());
        }
        return String.format("%s, %s, %s", acting.toString(), firstName.toString(), middleName.toString());
    }
}
