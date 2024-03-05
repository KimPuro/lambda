package user;

import enums.Messenger;

import java.util.List;
import java.util.Map;

public interface UserService {
    String addUsers();
    Messenger login(User user);
    Messenger updatePassword(User user);
    List<?> findUsersByName(String name);
    Map<String, ?> findUsersByNameFromMap(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobFromMap(String job);
    Map<String, ?> getUserMap();
}