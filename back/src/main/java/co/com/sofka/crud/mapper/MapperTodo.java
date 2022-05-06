package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.mapper.interfaces.IMapperTodo;
import co.com.sofka.crud.models.Todo;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public class MapperTodo implements IMapperTodo {

    @Autowired
    private ModelMapper modelMapper;

    public TodoDto entitymapperdto(Todo todo){
        TodoDto dto = new TodoDto();
        dto = modelMapper.map(todo, TodoDto.class);
        return dto;
    }

    public Todo dtomapperentity(TodoDto dto){
        Todo todo = modelMapper.map(dto, Todo.class);
        return todo;
    }

}
