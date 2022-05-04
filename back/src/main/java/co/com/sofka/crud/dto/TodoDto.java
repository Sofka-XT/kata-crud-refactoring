package co.com.sofka.crud.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TodoDto {

    private Long id;
    private String name;
    private boolean completed;
    private Long groupListId;

    public TodoDto(){

    }

}

