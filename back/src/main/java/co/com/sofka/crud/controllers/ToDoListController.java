package co.com.sofka.crud.controllers;

import co.com.sofka.crud.services.ToDoListService;
import co.com.sofka.crud.models.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoListController {

    @Autowired
    private ToDoListService service;

    @GetMapping(value = "api/todolists")
    public Iterable<ToDoList> list(){
        return service.list();
    }

    @PostMapping(value = "api/todolist")
    public ToDoList save(@RequestBody ToDoList toDoList){
        if (toDoList.getName().length() > 2 && toDoList.getName().length() <= 40) {
            return service.save(toDoList);
        }
        throw new RuntimeException("No se pudo crear, nombre debe tener entre 3 y 40 caracteres");
    }

    @PutMapping(value = "api/todolist")
    public ToDoList update(@RequestBody ToDoList toDoList){
        if (toDoList.getName().length() > 2 && toDoList.getName().length() <= 40) {
            if(toDoList.getId() != null){
                return service.save(toDoList);
            }
            throw new RuntimeException("No existe el id para actualziar");
        }
        throw new RuntimeException("No se pudo crear, nombre debe tener entre 3 y 40 caracteres");
    }

    @DeleteMapping(value = "api/{id}/todolist")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todolist")
    public ToDoList get(@PathVariable("id") Long id){
        return service.get(id);
    }

}