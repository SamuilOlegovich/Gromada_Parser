public class Data {
    private String area; // район
    private String region; // область
    private Address address;
    private String community; // громада
    private Person head;

    public Data(String rawData, String link) { this.parseString(rawData, link); }

    private void parseString(String string, String linc) {
        String[] strings = string.split(" Голова: ");
        String[] strings2 = strings[0].split(", ");
        String[] strings3 = strings2[0].split(" ");
        String[] strings4 = strings2[1].split(" ");
        this.head = new Person(strings[1]);
        this.address = new Address(strings[1], linc);
        this.community = strings3[0];
        this.region = strings3[2];
        this.area = strings4[0];
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s", community, region, area, head.toString(), address.toString());
    }
}
