package co.com.sofka.crud.service.interfaces;

import co.com.sofka.crud.models.Todo;

public interface ITodoService {
    public Iterable<Todo> list();
    public Todo save(Todo todo);
    public void delete(Long id);
    public Todo get(Long id);
}
