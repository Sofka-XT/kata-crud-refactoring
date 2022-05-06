package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoListDto;
import co.com.sofka.crud.mapper.interfaces.IMapperTodoList;
import co.com.sofka.crud.models.TodoList;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public class MapperTodoList implements IMapperTodoList {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TodoListDto entitylistmapperdtolist(TodoList todoList){
        TodoListDto todoListDto = new TodoListDto();
        todoListDto = modelMapper.map(todoList, TodoListDto.class);
        return todoListDto;
    }

    @Override
    public TodoList dtomapperTodolist(TodoListDto listDto){
        TodoList todoList = new TodoList();
        todoList = modelMapper.map(listDto, TodoList.class);
        return todoList;
    }
}
