package co.com.sofka.crud.service;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import co.com.sofka.crud.service.interfaces.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService implements ITodoService {

    @Autowired
    private TodoRepository repository;

    @Override
    public Iterable<Todo> list(){
        return repository.findAll();
    }

    @Override
    public Todo save(Todo todo){
        return repository.save(todo);
    }

    @Override
    public void delete(Long id){
        repository.delete(get(id));
    }

    @Override
    public Todo get(Long id){
         return repository.findById(id).orElseThrow();
    }

}
