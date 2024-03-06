package crawler;

import java.io.IOException;
import java.util.Map;

public interface CrawlerService {
    Map<String, ?> findBugsChart(Map<String, String> paramMap) throws IOException;

    Map<String, ?> findMelonChart(Map<String, String> paramMap) throws IOException;
}
