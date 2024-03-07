package user;

import common.AbstractService;
import common.UtilServiceImpl;
import enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.*;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Getter
    private static UserServiceImpl instance = new UserServiceImpl();
    UserRepository repo;
    Map<String, User> users;

    private UserServiceImpl(){
        this.users = new HashMap<>();
        this.repo = UserRepository.getInstance();
    }

    @Override
    public Messenger save(User user) {
        users.put(user.getUsername(), user);
        return Messenger.SUCCESS;
    }

    @Override
    public List<User> findAll() {
        return  new ArrayList<>(users.values());
    }

    @Override
    public Messenger login(User user) {
        return users.getOrDefault(user.getUsername(), User.builder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ?  Messenger.LOGGED_IN : Messenger.FAIL;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(users
                .values()
                .stream()
                .filter(i -> i.getId().equals(id))
                .collect(Collectors.toList()).get(0));
    }

    @Override
    public Messenger updatePassword(User user) {
        users.get(user.getUsername()).setPassword(user.getPassword());

        return Messenger.PASSWORD_CHANGED;
    }

    @Override
    public Messenger delete(User user) {
        users.remove(user.getUsername());
        return Messenger.DElETE_SUCCESS;
    }

    @Override
    public Boolean existsById(Long id) {
        return users.containsKey(id);
    }



    @Override
    public List<?> findUsersByName(String name) {
        return users
                .values()
                .stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
    }

    @Override
    public List<?> findUsersByJob(String job) {
            return users
                .values()
                .stream()
                .filter(i -> i.getJob().equals(job))
                .collect(Collectors.toList());
    }


    @Override
    public Map<String, ?> findUsersByJobFromMap(String job) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
    }

    @Override
    public String count() {
        return users.size()+"";
    }

    @Override
    public Optional<User> getOne(String id) {
        return Optional.of(users.get(id));
    }

    @Override
    public Map<String, ?> getUserMap() {
        return users;
    }

    @Override
    public String test() {
        return repo.test();
    }

    @Override
    public List<User> findUsers() throws SQLException {
        return (List<User>) repo.findUsers();
    }

    @Override
    public String addUsers() {
        IntStream.range(0,5)
                .mapToObj(i -> UtilServiceImpl.getInstance().createRandomUsername())
                .forEach(i -> users.put(i, User.builder()
                        .username(i)
                        .password("1")
                        .name(UtilServiceImpl.getInstance().createRandomName())
                        .job(UtilServiceImpl.getInstance().createRandomJob())
                        .build()));
        return users.size()+"개 더미값 추가";

    }
}