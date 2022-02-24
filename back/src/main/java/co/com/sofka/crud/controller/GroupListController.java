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

    @GetMapping(value = "/group")
    public Iterable<GroupList> list(){
        return service.list();
    }
    
    @PostMapping(value = "/group")
    public GroupList save(@RequestBody GroupList GroupList){
        return service.save(GroupList);
    }

    @PutMapping(value = "/group")
    public GroupList update(@RequestBody GroupList GroupList){
        if(GroupList.getId() != null){
            return service.save(GroupList);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "/{id}/group")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/{id}/group")
    public GroupList get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
