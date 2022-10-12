package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyUser {
    private long id;
    private String login;
    private String password;
}
