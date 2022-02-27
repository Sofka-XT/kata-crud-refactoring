package co.com.sofka.crud.services;

import co.com.sofka.crud.models.ToDoList;
import co.com.sofka.crud.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {
    @Autowired
    ToDoListRepository repository;

    public Iterable<ToDoList> list(){
        return repository.findAll();
    }

    public ToDoList save(ToDoList todoList){
        return repository.save(todoList);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public ToDoList get(Long id){
        return repository.findById(id).orElseThrow();
    }

}
