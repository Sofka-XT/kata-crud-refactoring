package co.com.sofka.crud.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class GroupList {
    @Id
    @GeneratedValue
    private Long id_groupList;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_groupList")
    private List<Todo> todos;

    public Long getId_groupList() {
        return id_groupList;
    }

    public void setId_groupList(Long id) {
        this.id_groupList = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}