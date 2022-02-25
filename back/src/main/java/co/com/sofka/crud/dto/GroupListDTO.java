package co.com.sofka.crud.dto;

import java.util.List;

public class GroupListDTO {

    private Long id_groupList;
    private String name;
    private List<TodoDTO> todos;

    public List<TodoDTO> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoDTO> todos) {
        this.todos = todos;
    }

    public Long getId_groupList() {
        return id_groupList;
    }

    public void setId_groupList(Long id_groupList) {
        this.id_groupList = id_groupList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}