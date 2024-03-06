package crawler;

import lombok.Getter;

import java.io.IOException;
import java.util.Map;

public class CrawlerServiceImpl implements CrawlerService{
    @Getter
    private static CrawlerServiceImpl instance = new CrawlerServiceImpl();
    private CrawlerRepository repository;
    private CrawlerServiceImpl() {
        repository = CrawlerRepository.getInstance();
    }

    @Override
    public Map<String, ?> findBugsChart(Map<String, String> paramMap) throws IOException {
        return repository.bugsSave(paramMap);
        }
    @Override
    public Map<String, ?> findMelonChart(Map<String, String> paramMap) throws IOException {
        return repository.melonSave(paramMap);
    }
}