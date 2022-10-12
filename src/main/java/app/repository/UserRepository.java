package app.repository;

import app.model.MyUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<MyUser> users = new ArrayList<>();


    public MyUser findByLogin(String login) {
        return users.stream().filter(t -> t.getLogin().equals(login)).findFirst().orElseThrow(() -> new RuntimeException("No user with login: " + login));
    }

    public void add(MyUser t) {
        users.add(t);
    }

}
