package co.com.sofka.crud.service.interfaces;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.models.Todo;

public interface ITodoService {
    public Iterable<TodoDto> list();
    public TodoDto save(TodoDto dto);
    public void delete(Long id);
    public TodoDto get(Long id);
}
