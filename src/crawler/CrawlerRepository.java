package crawler;

import common.AbstractRepository;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class CrawlerRepository extends AbstractRepository {
    @Getter
    private static CrawlerRepository instance = new CrawlerRepository();
    private CrawlerRepository() {
        map = new LinkedHashMap<>();
    }

    private LinkedHashMap<String, Map<String, String>> map;
   @Override
    public Map<String, ?> bugsSave(Map<String, ?> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://music.bugs.co.kr/chart").get();
        Elements element = doc.select("table.byChart");
        Iterator<Element> titleIt = element.select("p.title").iterator();
        Iterator<Element> artistIt = element.select("p.artist").iterator();
        Iterator<Element> rankIt = element.select("strong").iterator();

       return getStringMap(titleIt, artistIt, rankIt);
   }

    @Override
    public Map<String, ?> melonSave(Map<String, ?> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
        Elements elems = doc.select("tbody");
        Iterator<Element> titleIt = elems.select("div.ellipsis.rank01 > span").iterator();
        Iterator<Element> artistIt = elems.select("div.ellipsis.rank02 span").iterator();
        Iterator<Element> rankIt = elems.select("td span.rank").iterator();

        return getStringMap(titleIt, artistIt, rankIt);
    }
    private Map<String, ?> getStringMap(Iterator<Element> titleIt, Iterator<Element> artistIt, Iterator<Element> rankIt) {
        while (titleIt.hasNext() && artistIt.hasNext() && rankIt.hasNext()) {
            String title = titleIt.next().text();
            String artist = artistIt.next().text();
            String rank = rankIt.next().text();

            Map<String, String> musicInfoMap = new LinkedHashMap<>();
            musicInfoMap.put("가수", artist);
            musicInfoMap.put("순위", rank);

            map.put(title, musicInfoMap);

        }
        return map;
    }
}
