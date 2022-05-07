package co.com.sofka.crud.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="list")
public class TodoList{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    @Column()
    private String nameList;

    //Relacion de uno a muchos, debido a que un TodoList puede contener varios todo
    @OneToMany(fetch = FetchType.EAGER,
                targetEntity = Todo.class,
                cascade = CascadeType.REMOVE,
                mappedBy = "list")
    @JsonManagedReference
    private List<Todo> todos = new ArrayList<>();

    public TodoList(){

    }

    public TodoList(String name){
        this.nameList =name;
    }
}
