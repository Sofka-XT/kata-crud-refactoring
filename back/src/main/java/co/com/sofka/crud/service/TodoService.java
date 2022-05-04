package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.mapper.MapperTodoDto;
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
    private ModelMapper modelMapper;

    @Override
    public Iterable<TodoDto> list(){
        List<TodoDto>dtos = new ArrayList<>();
        repository.findAll().forEach(todo->dtos.add(modelMapper.map(todo,TodoDto.class)));
        return dtos;
    }

    @Override
    public TodoDto save(TodoDto dto){
        Todo todoEntity =modelMapper.map(dto,Todo.class);
        todoEntity = repository.save(todoEntity);
        return modelMapper.map(todoEntity,TodoDto.class);
    }

    @Override
    public void delete(Long id){
        repository.delete(get(id));
    }

    @Override
    public Todo get(Long id){
        Optional<Todo> optionalTodo = repository.findById(id);
        if(optionalTodo.isEmpty()){
            throw new NoSuchElementException("No existe una lista con ese id");
        }
        return repository.findById(id).orElseThrow();
    }

}
