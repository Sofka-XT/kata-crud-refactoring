package co.com.sofka.crud.controller;


import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService service;

    @CrossOrigin
    @GetMapping(value = "/todos")
    public Iterable<Todo> list() {
        return service.list();
    }

    @PostMapping(value = "/todo")
    public Todo save(@RequestBody Todo todo) {
        return service.save(todo);
    }


    @PutMapping(value = "/todo")
    public Todo update(@RequestBody Todo todo) {
        if (todo.getId_todo() != null) {
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }


    @DeleteMapping(value = "/{id}/todo")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(value = "/{id}/todo")
    public Todo get(@PathVariable("id") Long id) {
        return service.get(id);
    }
}