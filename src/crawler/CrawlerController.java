package crawler;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CrawlerController {
    private CrawlerServiceImpl service = CrawlerServiceImpl.getInstance();
    public Map<String,?> findBugsMusic(Scanner sc) throws IOException {
        System.out.println("검색할 URL을 입력하세요");
        String url = sc.next();
        Map<String, String> paramMap = new LinkedHashMap<>();
        paramMap.put("url", url);

        return service.findBugsChart(paramMap);
    }
    public Map<String,?> findMelonMusic(Scanner sc) throws IOException {
        System.out.println("검색할 URL을 입력하세요");
        String url = sc.next();
        Map<String, String> paramMap = new LinkedHashMap<>();
        paramMap.put("url", url);

        return service.findMelonChart(paramMap);
    }

}
