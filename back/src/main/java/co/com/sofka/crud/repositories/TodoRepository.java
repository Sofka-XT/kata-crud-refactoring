package co.com.sofka.crud.repositories;

import co.com.sofka.crud.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findByListId (Integer id);
}
