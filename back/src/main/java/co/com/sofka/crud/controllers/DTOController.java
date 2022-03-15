package co.com.sofka.crud.controllers;

import co.com.sofka.crud.models.ToDoListDTO;
import co.com.sofka.crud.services.DTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DTOController {
    @Autowired
    DTOService dtoService;

    @GetMapping(value = "api/{id}/list")
    public ToDoListDTO getByListId(@PathVariable("id") Long id){
        return dtoService.findList(id);
    }
}
