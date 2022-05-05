package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.mapper.intefezamapper.IMapperTodo;
import co.com.sofka.crud.models.Todo;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;



@Mapper(componentModel="spring")
public class MapperTodo implements IMapperTodo {

    @Autowired
    Todo todo1;

    @Autowired
    TodoDto dto;

    @Autowired
    private ModelMapper mapper;

    @Override
    public TodoDto entitytodto(Todo todo) {
    dto = mapper.map(todo,TodoDto.class);
        return dto;
    }

    @Override
    public Todo dtoToEntity(TodoDto dto) {
        todo1 = mapper.map(dto,Todo.class);
        return todo1;
    }
}
