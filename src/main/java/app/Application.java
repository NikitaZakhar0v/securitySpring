package app;

import app.model.MyUser;
import app.model.Tovar;
import app.repository.TovarRepository;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TovarRepository tovarRepository = context.getBean(TovarRepository.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        userRepository.add(new MyUser(1, "a", "b"));
        userRepository.add(new MyUser(2, "a2", "b"));
        tovarRepository.add(new Tovar(1, "tovar1"));
        tovarRepository.add(new Tovar(2, "tovar2"));
        tovarRepository.add(new Tovar(3, "tovar3"));
        tovarRepository.add(new Tovar(4, "tovar4"));
    }
}
