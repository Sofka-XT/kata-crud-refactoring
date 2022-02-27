package co.com.sofka.crud.models;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean completed;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="fk_toDoList")
    private Long toDoList;

    public Long getToDoList() {
        return toDoList;
    }

    public void setToDoList(Long toDoList) {
        this.toDoList = toDoList;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
