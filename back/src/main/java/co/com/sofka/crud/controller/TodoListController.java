package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.TodoListDto;
import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Lit")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoListController {
    @Autowired
    private TodoListService service;

    @GetMapping(value = "api/todos")
    public Iterable<TodoListDto> list() {
        return service.list();
    }

    @PostMapping(value = "api/todo")
    public TodoListDto save(@RequestBody TodoListDto dto) {
        return service.save(dto);
    }

    @PutMapping(value = "api/todo/actualizar")
    public TodoListDto update(@RequestBody TodoListDto dto) {
        if (dto.getId() != null) {
            return service.save(dto);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public TodoList get(@PathVariable("id") Long id) {
        return service.get(id);
    }

}
