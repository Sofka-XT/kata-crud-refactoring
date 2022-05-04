package co.com.sofka.crud.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column()
    private String name;

    @Column()
    private boolean completed;

    @Column()
    private Long group_list_id;


    public Todo(){

    }

    public Todo(String name, boolean completed, Long group_list_id) {
        this.name = name;
        this.completed = completed;
        this.group_list_id = group_list_id;
    }
}
