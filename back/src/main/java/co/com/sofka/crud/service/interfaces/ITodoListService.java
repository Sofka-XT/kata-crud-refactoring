package co.com.sofka.crud.service.interfaces;

import co.com.sofka.crud.dto.TodoListDto;
import co.com.sofka.crud.models.TodoList;

public interface ITodoListService {
    public Iterable<TodoListDto> list();
    public TodoListDto save(TodoListDto dto);
    public void delete(Long id);
    public TodoList get(Long id);

}
