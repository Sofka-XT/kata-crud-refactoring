package co.com.sofka.crud.services;

import co.com.sofka.crud.models.ToDoList;
import co.com.sofka.crud.models.ToDoListDTO;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.ToDoListRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DTOService {
    @Autowired
    ToDoListRepository listRepository;

    @Autowired
    TodoRepository todoRepository;

    public ToDoListDTO findList(Long id) {
        Optional<ToDoList> list = listRepository.findById(id);
        List<Todo> todos = todoRepository.findByToDoList(id);

        ToDoListDTO dto = new ToDoListDTO();
        dto.setId(list.get().getId());
        dto.setName(list.get().getName());
        dto.setTodos(todos);

        return dto;
    }
}
