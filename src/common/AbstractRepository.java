package common;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractRepository {
    public abstract Map<String, ?> bugsSave(Map<String, ?> paramMap) throws IOException;

    public abstract Map<String, ?> melonSave(Map<String, ?> paramMap) throws IOException;
}
