package co.com.sofka.crud.controllers;

import co.com.sofka.crud.services.TodoService;
import co.com.sofka.crud.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<Todo> list(){
        return service.list();
    }
    
    @PostMapping(value = "api/todo")
    public Todo save(@RequestBody Todo todo){
        if (todo.getName().length() > 2 && todo.getName().length() <= 40) {
            return service.save(todo);
        }
        throw new RuntimeException("No se pudo crear, nombre debe tener entre 3 y 40 caracteres");
    }

    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody Todo todo){
        if (todo.getName().length() > 2 && todo.getName().length() <= 40) {
            if(todo.getId() != null){
                return service.save(todo);
            }
            throw new RuntimeException("No existe el id para actualziar");
        }
        throw new RuntimeException("No se pudo crear, nombre debe tener entre 3 y 40 caracteres");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @GetMapping(value = "api/{id}/todos")
    public List<Todo> getByListId(@PathVariable("id") Long id){
        return service.findByToDoList(id);
    }

}
