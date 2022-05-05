package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoListDto;
import co.com.sofka.crud.mapper.intefezamapper.IMapperTodoList;
import co.com.sofka.crud.models.TodoList;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public class MapperTodoList implements IMapperTodoList {

    @Autowired
    TodoList todoList1;

    @Autowired
    TodoListDto listDto;

    @Autowired
    private ModelMapper mapper;

    @Override
    public TodoListDto entitytodto(TodoList listtodo) {
        listDto = mapper.map(listtodo, TodoListDto.class);
        return listDto;
    }

    @Override
    public TodoList dtoToEntity(TodoListDto dto) {
        todoList1 = mapper.map(dto, TodoList.class);
        return todoList1;
    }
}
