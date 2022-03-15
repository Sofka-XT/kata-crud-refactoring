package co.com.sofka.crud.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ToDoList {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "todolist_todo",
            joinColumns = @JoinColumn(name = "todolist_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "todo_id", referencedColumnName = "id"))
    private List<Todo> Todos = new ArrayList<>();

    public void setTodos(List<Todo> todos) {
        Todos = todos;
    }

    public List<Todo> getTodos() {
        return Todos;
    }

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
}
