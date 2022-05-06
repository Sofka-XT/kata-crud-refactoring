package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.mapper.MapperTodo;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import co.com.sofka.crud.service.interfaces.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoService implements ITodoService {

    @Autowired
    private TodoRepository repository;

    @Autowired
    private MapperTodo mapper;

    @Override
    public Iterable<TodoDto> list(){
        List<TodoDto> dtos = new ArrayList<>();
        repository.findAll().forEach(todo -> dtos.add(mapper.entitymapperdto(todo)));
        return dtos;
    }

    @Override
    public TodoDto save(TodoDto dto){
        if(dto.getName()==null){
            throw new DuplicateKeyException("Debe ingresar un nombre");
        }
        Todo todo = mapper.dtomapperentity(dto);
        return mapper.entitymapperdto(repository.save(todo));
    }

    @Override
    public void delete(Long id){
        Todo todo = new Todo();
        todo = mapper.dtomapperentity(get(id));
        repository.delete(todo);
    }

    @Override
    public TodoDto get(Long id){
        Optional<Todo> optionalListTodo = repository.findById(id);
        if(optionalListTodo.isEmpty()){
            throw new NoSuchElementException("No existe una tarea con el id " + id);
        }
        return  mapper.entitymapperdto(optionalListTodo.get());
    }

}