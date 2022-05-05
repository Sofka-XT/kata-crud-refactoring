package co.com.sofka.crud.mapper.intefezamapper;


import co.com.sofka.crud.dto.TodoListDto;
import co.com.sofka.crud.models.TodoList;

public interface IMapperTodoList {

    public TodoListDto entitytodto(TodoList todolist);
    public TodoList dtoToEntity(TodoListDto dto);
}
