package app.repository;

import app.model.Tovar;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TovarRepository {
    private List<Tovar> tovars = new ArrayList<>();


    public List<Tovar> findAll() {
        return tovars;
    }

    public Tovar findById(long id) {
        return tovars.stream().filter(t -> t.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("No tovar with id: " + id));
    }

    public void add(Tovar t) {
        tovars.add(t);
    }


}
