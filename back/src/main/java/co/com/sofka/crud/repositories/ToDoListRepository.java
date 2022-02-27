package co.com.sofka.crud.repositories;

import co.com.sofka.crud.models.ToDoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {
}
