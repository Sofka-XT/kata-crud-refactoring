package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.TodoListDto;
import co.com.sofka.crud.mapper.MapperTodoList;
import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.repository.TodoListRepository;
import co.com.sofka.crud.service.interfaces.ITodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoListService implements ITodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    private MapperTodoList mapper;

    @Override
    public Iterable<TodoListDto> list(){
        List<TodoListDto> dtos =new ArrayList<>();
        todoListRepository.findAll().forEach(todoByCategory -> dtos.add(mapper.mapperTodoListDto(todoByCategory)));
        return dtos;
    }

    @Override
    public TodoListDto save(TodoListDto dto){
        if(dto.getNameList() ==null){
            throw new DuplicateKeyException("Debe ingresar un nombre");
        }
        TodoList todoList = mapper.mapperTodoList(dto);
        return mapper.mapperTodoListDto(todoListRepository.save(todoList));
    }

    @Override
    public void delete(Long id){
        TodoList todoList = new TodoList();
        todoList = mapper.mapperTodoList(get(id));
        todoListRepository.delete(todoList);
    }

    @Override
    public TodoListDto get(Long id){
        Optional<TodoList> optionalList = todoListRepository.findById(id);
        if(optionalList.isEmpty()){
            throw new NoSuchElementException("No existe una categoria con el id " + id);
        }
        return  mapper.mapperTodoListDto(optionalList.get());
    }
}

