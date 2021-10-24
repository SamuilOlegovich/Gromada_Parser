public class Person {
    private FirstName firstName;
    private LastName lastName;
    private MiddleName middleName;
    private String acting; // исполняющий обязанности

    public Person(String string) {
        this.parseString(string);
    }

    private void parseString(String string) {
        String[] strings = string.split(" Телефон: ");
        String[] strings1 = strings[0].split(" ");
        if (strings1.length == 3) {
            this.lastName = new LastName(strings1[0]);
            this.firstName = new FirstName(strings1[1]);
            this.middleName = new MiddleName(strings1[2]);
            this.acting = "absent";
        } else {
            strings = string.split(" Секретар: ");
            this.middleName = null;
            this.lastName = null;
            this.firstName = null;
            this.acting = strings[0];
        }
    }

    @Override
    public String toString() {
        if (acting.equals("absent")) {
            return String.format("%s, %s, %s", lastName.toString(), firstName.toString(), middleName.toString());
        }
        return String.format("%s, %s, %s", acting, firstName.toString(), middleName.toString());
    }
}
