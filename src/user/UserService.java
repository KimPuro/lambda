package user;


import java.util.List;
import java.util.Map;

public interface UserService {
    String addUsers();
    String join(User user);
    String login(User user);
    User findUserByID(String username);
    void updatePassword(User user);
    String deleteUser(String username);
    List<User> getUserList();
    List<User> findUsersByName(String name);
    Map<String, ?> findUsersByNameFromMap(String name);
    List<User> findUserByJob(String job);
    int countUsers();
}
