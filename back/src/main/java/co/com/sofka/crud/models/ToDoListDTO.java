package co.com.sofka.crud.models;

import java.io.Serializable;
import java.util.List;

public class ToDoListDTO implements Serializable {
    private Long id;
    private String name;
    private List todos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getTodos() {
        return todos;
    }

    public void setTodos(List todos) {
        this.todos = todos;
    }
}
