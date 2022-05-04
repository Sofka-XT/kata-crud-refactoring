package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.dto.TodoListDto;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.repository.TodoListRepository;
import co.com.sofka.crud.repository.TodoRepository;
import co.com.sofka.crud.service.interfaces.ITodoListService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoListService implements ITodoListService {
    @Autowired
    private TodoListRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<TodoListDto> list(){
        List<TodoListDto> dtos = new ArrayList<>();
        repository.findAll().forEach(todoList ->dtos.add(modelMapper.map(todoList,TodoListDto.class)));
        return dtos;
    }

    @Override
    public TodoListDto save(TodoListDto dto){
        TodoList todoListEntity =modelMapper.map(dto,TodoList.class);
        todoListEntity = repository.save(todoListEntity);
        return modelMapper.map(todoListEntity,TodoListDto.class);
    }

    @Override
    public void delete(Long id){
        repository.delete(get(id));
    }

    @Override
    public TodoList get(Long id){
        Optional<TodoList> optionalTodo = repository.findById(id);
        if(optionalTodo.isEmpty()){
            throw new NoSuchElementException("No existe una lista con ese id");
        }
        return repository.findById(id).orElseThrow();
    }
}

