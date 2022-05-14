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

    //convertir de todoList a todolistdto
    @Override
    public TodoListDto mapperTodoListDto(TodoList todoList){
        TodoListDto todoListDto = new TodoListDto();
        todoListDto = modelMapper.map(todoList, TodoListDto.class);
        return todoListDto;
    }

    //convertir de todoDto a todoList
   @Override
    public TodoList mapperTodoList(TodoListDto listDto){
        TodoList todoList = new TodoList();
        todoList = modelMapper.map(listDto, TodoList.class);
        return todoList;
    }
}
