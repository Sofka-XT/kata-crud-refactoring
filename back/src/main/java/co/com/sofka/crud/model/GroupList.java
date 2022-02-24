package co.com.sofka.crud.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GroupList")
public class GroupList {
    @Id
    @GeneratedValue
    private Long id;
    private String nameGroup;

    //la persistencia cascada guarda los datos de varios objetos/tablas a la misma vez
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idGroupList")

    private Set<Todo> todo;

    public Set<Todo> getTodo() {
        return todo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idGroupList) {
        this.id = idGroupList;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

}
