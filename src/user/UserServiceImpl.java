package user;


import common.UtilService;
import common.UtilServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{
    private Map<String, User> users;
    UserRepository userRepository;
    @Override
    public String addUsers() {
        Map<String, User> map = new HashMap<>();
        UtilService util = UtilServiceImpl.getInstance();

        for(int i=0; i<5; i++){
            String username = util.createRandomName();
            map.put(username, User.builder()
                    .username(username)
                    .pw("1")
                    .name(util.createRandomName())
                    .build());
        }
        users = map;
        return users.size()+" 개 더미값 추가";
    }

    @Override
    public String join(User user) {
        return null;
    }

    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public User findUserByID(String username) {
        return null;
    }

    @Override
    public void updatePassword(User user) {

    }

    @Override
    public String deleteUser(String username) {
        return null;
    }

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public List<User> findUsersByName(String name) {
        return users
                .values()
                .stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public List<User> findUserByJob(String job) {
        return null;
    }

    @Override
    public int countUsers() {
        return 0;
    }
}
