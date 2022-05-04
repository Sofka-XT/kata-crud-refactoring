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
    private String groupListId;


    public Todo(){

    }

}
