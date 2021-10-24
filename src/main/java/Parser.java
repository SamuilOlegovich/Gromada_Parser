import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class Parser {
    private static final String URI = "https://gromada.org.ua/dijuchi-gromadi/?p=";
    private static final String FILE = "/Users/samuilolegovich/Desktop/parse.csv";
    private static final String CLASS_NAME = "one_gromada";
    private static final String ATTRIBUTE_KEY = "href";
    private static final String TAG = "a";

    private static final int MAX = 58;
    private static final int MIN = 1;

    public static void main(String[] args) throws IOException {
        List<Data> parsed = parseData();
        outInfo(parsed);
        parsed.clear();
    }

    private static List<Data> parseData() {
        List<Data> parsed = new ArrayList<Data>();
        for (int i = MIN; i <= MAX; i++) {
            try {
                Document doc = Jsoup.connect(URI + i).get();
                for (Element card : doc.body().getElementsByClass(CLASS_NAME)) {
                    Elements links = card.getElementsByTag(TAG);
                    for (Element row : links) {
                        String link = row.attr(ATTRIBUTE_KEY);
                        parsed.add(new Data(card.text(), link));
                    }
                }
            } catch (IOException e) { e.printStackTrace(); }
        }
        return parsed;
    }

    private static void outInfo(List<Data> parseData) throws FileNotFoundException, IOException {
        String head = "Название, Какой области, Какого района, Фамилия, Имя," +
                " Отчество, Телефон, Инднкс, Область, Район, Село/Город, Улица, Дом, Линк,";
        File file = new File(FILE);
        OutputStream outStream = new FileOutputStream(file);
        System.out.println(head);
        outStream.write(head.getBytes());
        outStream.write("\n".getBytes());
        for (Data linc : parseData) {
            System.out.println(linc.toString());
            outStream.write(linc.toString().getBytes());
            outStream.write("\n".getBytes());
        }
        outStream.close();
    }
}
