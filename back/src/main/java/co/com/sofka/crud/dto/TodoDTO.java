package co.com.sofka.crud.dto;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class TodoDTO implements Serializable {
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

    public Long getId_todo() {
        return id_todo;
    }

    public void setId_todo(Long id_todo) {
        this.id_todo = id_todo;
    }

    public String getName() {
        return StringUtils.defaultString(name);
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