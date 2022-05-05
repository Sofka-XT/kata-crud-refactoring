package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoListDto;
import co.com.sofka.crud.mapper.MapperTodoList;
import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.repository.TodoListRepository;
import co.com.sofka.crud.service.interfaces.ITodoListService;
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
    private MapperTodoList mapper;

    @Override
    public Iterable<TodoListDto> list(){
        List<TodoListDto> dtos = new ArrayList<>();
        repository.findAll().forEach(todoList ->dtos.add(mapper.entitytodto(todoList)));
        return dtos;
    }

    @Override
    public TodoListDto save(TodoListDto dto){
        TodoList todoListEntity =mapper.dtoToEntity(dto);
        todoListEntity = repository.save(todoListEntity);
        return mapper.entitytodto(todoListEntity);
          }

    @Override
    public void delete(Long id){
        TodoList todoListEntity = mapper.dtoToEntity(get(id));
        repository.delete(todoListEntity);
         }

    @Override
    public TodoListDto get(Long id){
        Optional<TodoList> optionalTodoList = repository.findById(id);
        if(optionalTodoList.isEmpty()){
            throw new NoSuchElementException("No existe una lista con ese id");
        }
        TodoListDto todoListDto = mapper.entitytodto(optionalTodoList.get());
        return todoListDto;
    }
}

