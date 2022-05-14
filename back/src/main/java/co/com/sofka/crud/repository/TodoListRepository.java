package co.com.sofka.crud.repository;


import co.com.sofka.crud.models.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList,Long> {
}

