package co.com.sofka.crud.service.interfaces;

import co.com.sofka.crud.dto.TodoListDto;

public interface ITodoListService {
    public Iterable<TodoListDto> list();
    public TodoListDto save(TodoListDto dto);
    public void delete(Long id);
    public TodoListDto get(Long id);

}
