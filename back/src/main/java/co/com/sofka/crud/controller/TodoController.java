package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "/todos")
    public Iterable<TodoDto> list(){
        return service.list();
    }

    @PostMapping(value = "/todo")
    public TodoDto save(@RequestBody TodoDto dto){
        return service.save(dto);
    }

    @PutMapping(value = "/todo")
    public TodoDto update(@RequestBody TodoDto dto){
        if(dto.getId() != null){
            return service.save(dto);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/{id}/todo")
    public TodoDto get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
