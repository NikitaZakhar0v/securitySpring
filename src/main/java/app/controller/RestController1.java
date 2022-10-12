package app.controller;

import app.model.Tovar;
import app.repository.TovarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestController1 {
    private final TovarRepository tovarRepository;

    public RestController1(TovarRepository tovarRepository) {
        this.tovarRepository = tovarRepository;
    }

    @GetMapping("/all")
    public List<Tovar> findAll() {
        return tovarRepository.findAll();
    }

    @GetMapping("/find/id/{id}")
    public Tovar findAll(@PathVariable long id) {
        return tovarRepository.findById(id);
    }

    @GetMapping("/find/name/{name}")
    public Tovar findByName(@PathVariable String name) {
        Tovar tovar2 = tovarRepository.findAll().stream().filter(tovar -> tovar.getName().equals(name)).findFirst().orElseThrow(() -> new RuntimeException("бла бла бла"));
        return tovar2;
    }


    @PostMapping("/add")
    public void add(@RequestBody Tovar tovar) {
        tovarRepository.add(tovar);
    }

    @PutMapping("/update")
    public Tovar update(@RequestBody Tovar tovar) {
        Tovar tovar1 = tovarRepository.findById(tovar.getId());
        tovar1.setName(tovar.getName());
        return tovar1;
    }


    @GetMapping("/test")
    public String test() {
        return "hello";
    }

}
