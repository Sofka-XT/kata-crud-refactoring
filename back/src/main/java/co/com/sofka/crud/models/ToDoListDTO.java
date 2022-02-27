package co.com.sofka.crud.models;

import java.io.Serializable;
import java.util.List;

public class ToDoListDTO implements Serializable {
    private Long id;
    private Integer listId;
    private String listName;
    private List todos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List getTodos() {
        return todos;
    }

    public void setTodos(List todos) {
        this.todos = todos;
    }
}
