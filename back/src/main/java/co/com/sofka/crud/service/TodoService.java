package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.mapper.MapperTodo;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import co.com.sofka.crud.service.interfaces.ITodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<TodoDto>dtos = new ArrayList<>();
        repository.findAll().forEach(todo -> dtos.add(mapper.entitytodto(todo)));
        return dtos;
    }

    @Override
    public TodoDto save(TodoDto dto){
        Todo todoEntity =mapper.dtoToEntity(dto);
        todoEntity = repository.save(todoEntity);
        return mapper.entitytodto(todoEntity);
    }

    @Override
    public void delete(Long id){
        Todo todoEntity = mapper.dtoToEntity(get(id));
        repository.delete(todoEntity);
    }

    @Override
    public TodoDto get(Long id){
        Optional<Todo> optionalTodo = repository.findById(id);
        if(optionalTodo.isEmpty()){
            throw new NoSuchElementException("No existe una lista con ese id");
        }
        TodoDto tododto = mapper.entitytodto(optionalTodo.get());
        return tododto;
    }

}
