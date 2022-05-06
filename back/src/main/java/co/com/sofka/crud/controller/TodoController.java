package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<TodoDto> list(){
        return service.list();
    }

    @PostMapping(value = "api/todo")
    public TodoDto save(@RequestBody TodoDto dto){
        return service.save(dto);
    }

    @PutMapping(value = "api/todo")
    public TodoDto update(@RequestBody TodoDto dto){
        if(dto.getId() != null){
            return service.save(dto);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public TodoDto get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
