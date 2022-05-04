package co.com.sofka.crud.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="ListTodo")
public class TodoList{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_list", nullable = false)
    private Long idList;

    @Column()
    private String nameList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_list_id")
    private List<Todo> todos = new ArrayList<>();

    public TodoList(){

    }
}
