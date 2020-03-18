package co.com.sofka.crud;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Iterable<Todo> findAllByGroupListId(String groupListId);
}
