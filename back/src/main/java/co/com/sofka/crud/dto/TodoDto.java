package co.com.sofka.crud.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class TodoDto {

    private Long id;

    private String name;
    private boolean completed;
    private String groupListId;

    public TodoDto(){

    }

    public TodoDto(String name, boolean completed, String groupListId) {
        this.name = name;
        this.completed = completed;
        this.groupListId = groupListId;
    }
}

