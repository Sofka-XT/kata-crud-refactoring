package co.com.sofka.crud.mapper.interfaces;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.models.Todo;

public interface IMapperTodo  {
    public TodoDto entitymapperdto(Todo todo);
    public Todo dtomapperentity(TodoDto dto);
}
