public class Person {
    private String name;
    private String surname; // фамилия
    private String middleName; // Отчество
    private String acting; // исполняющий обязанности

    public Person(String string) {
        this.parseString(string);
    }

    private void parseString(String string) {
        String[] strings = string.split(" Телефон: ");
        String[] strings1 = strings[0].split(" ");
        if (strings1.length == 3) {
            this.middleName = strings1[2];
            this.surname = strings1[0];
            this.name = strings1[1];
            this.acting = "absent";
        } else {
            strings = string.split(" Секретар: ");
            this.middleName = null;
            this.surname = null;
            this.name = null;
            this.acting = strings[0];
        }
    }

    @Override
    public String toString() {
        if (acting.equals("absent")) {
            return String.format("%s, %s, %s", surname, name, middleName);
        }
        return String.format("%s, %s, %s", acting, name, middleName);
    }
}
