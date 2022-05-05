package co.com.sofka.crud.mapper.intefezamapper;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.models.Todo;

public interface IMapperTodo {
    public TodoDto entitytodto(Todo todo);
    public Todo  dtoToEntity(TodoDto dto);
}
