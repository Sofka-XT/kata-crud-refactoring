package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.TodoListDto;
import co.com.sofka.crud.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/List")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoListController {
    @Autowired
    private TodoListService listService;

    @GetMapping(value = "/todoslist")
    public Iterable<TodoListDto> list(){
        return listService.list();
    }

    @PostMapping(value = "/todolist")
    public TodoListDto save(@RequestBody TodoListDto dto){
        return listService.save(dto);
    }

    @PutMapping(value = "/todolist")
    public TodoListDto update(@RequestBody TodoListDto dto){
        if(dto.getId() != null){
            return listService.save(dto);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "/{id}/todolist")
    public void delete(@PathVariable("id")Long id){
        listService.delete(id);
    }

    @GetMapping(value = "/{id}/todolist")
    public TodoListDto get(@PathVariable("id") Long id){
        return listService.get(id);
    }
}
