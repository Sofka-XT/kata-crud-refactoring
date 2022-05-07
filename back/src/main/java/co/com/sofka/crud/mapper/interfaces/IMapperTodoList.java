package co.com.sofka.crud.mapper.interfaces;

import co.com.sofka.crud.dto.TodoListDto;
import co.com.sofka.crud.models.TodoList;

public interface IMapperTodoList {
    public TodoListDto mapperTodoListDto(TodoList todoList);
    public TodoList mapperTodoList(TodoListDto listDto);
}
