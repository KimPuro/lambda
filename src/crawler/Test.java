package crawler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
    public static void main(String[] args) {
        String url = "https://music.bugs.co.kr/chart";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            Elements element = doc.select("table.byChart");
            Iterator<Element> title = element.select("p.title").iterator();
            Iterator<Element> artist = element.select("p.artist").iterator();
            Iterator<Element> rank = element.select("strong").iterator();

            PrintWriter writer = new PrintWriter("Crawler.txt", "UTF-8");

            while (rank.hasNext()) {
                String output = rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text();
                System.out.println(output);
                writer.println(output);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}