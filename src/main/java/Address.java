public class Address {
    private int index;              // индекс
    private String phone;           // телефон
    private String region;          // область
    private String area;            // район
    private String villageCity;     // село город
    private String street;          // улица
    private String house;           // дом
    private String link;            // линк
    private boolean flag;

    public Address(String string, String link) {
        this.link = link;
        this.flag = false;
        this.parseString(string);
    }

    private void parseString(String string) {
        String[] strings = string.split(" Телефон: ");
        String[] strings1 = strings[1].split(" Адреса: ");
        this.phone = strings1[0];
        String[] strings2 = strings1[1].split(", ");

        try { this.index = Integer.parseInt(strings2[0]);
        } catch (NumberFormatException e) {
            this.index = -1;
            this.flag = true;
        }

        if (!flag) {
            if (strings2.length > 4) {
                this.street = strings2[4];
                if (strings2.length > 5) {
                    String[] strings3 = strings2[5].split(" Перейти ");
                    this.house = strings3[0];
                } else this.house = null;
            } else this.street = null;
            if (strings2.length == 3) {
                String[] arr = strings2[1].split(" ");
                String[] arr2 = strings2[2].split(" ");
                this.villageCity = arr[4] + " " + arr[5];
                this.area = strings2[2];
                this.region = arr[0];
                this.street = arr[7] + " " + arr2[0];
                this.house = arr2[0];
            } else {
                this.villageCity = strings2[3];
                this.region = strings2[1];
                this.area = strings2[2];
            }
        } else {
            if (strings2.length > 3) {
                this.street = strings2[3];
                if (strings2.length > 4) {
                    String[] strings3 = strings2[4].split(" Перейти ");
                    this.house = strings3[0];
                } else this.house = null;
            } else this.street = null;
            this.villageCity = strings2[2];
            this.region = strings2[0];
            this.area = strings2[1];
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s, %s, %s, %s, %s, %s",
                phone, index, region, area, villageCity, street, house, link);
    }
}
