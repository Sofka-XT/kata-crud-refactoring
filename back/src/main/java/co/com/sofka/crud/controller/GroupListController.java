package co.com.sofka.crud.controller;

import co.com.sofka.crud.model.GroupList;
import co.com.sofka.crud.service.GroupListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class GroupListController {

    @Autowired
    private GroupListService service;
    @GetMapping(value = "/groupList")
    public Iterable<GroupList> list(){
        return service.list();
    }

    @PostMapping(value = "/groupList")
    public GroupList save(@RequestBody GroupList todo){
        return service.save(todo);
    }

    @PutMapping(value = "/groupList")
    public GroupList update(@RequestBody GroupList todo){
        return service.save(todo);
    }

    @DeleteMapping(value = "/{id}/groupList")
    public void delete(@PathVariable("id") Long id){
        service.delete(get(id));
    }

    @GetMapping(value = "/{id}/groupList")
    public Long get(@PathVariable("id") Long id){
        return service.get(id).getId_groupList();
    }
}