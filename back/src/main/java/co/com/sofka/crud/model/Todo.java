package co.com.sofka.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue
    private Long id_todo;
    private String name;
    private boolean completed;
    private Long id_groupList;

    public Long getId_groupList() {
        return id_groupList;
    }

    public void setId_groupList(Long id_groupList) {
        this.id_groupList = id_groupList;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setId_todo(Long id) {
        this.id_todo = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_todo() {
        return id_todo;
    }
}
