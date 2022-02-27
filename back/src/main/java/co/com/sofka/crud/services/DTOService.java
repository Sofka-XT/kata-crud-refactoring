package co.com.sofka.crud.services;

import co.com.sofka.crud.models.ToDoList;
import co.com.sofka.crud.models.ToDoListDTO;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.ToDoListRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;

public class DTOService {
    @Autowired
    ToDoListRepository listRepository;

    @Autowired
    TodoRepository todoRepository;

    private ToDoListDTO findList(Long id) {
        Optional<ToDoList> list = listRepository.findById(id);
        List<Todo> todos = todoRepository.findByToDoList(id);

        //Create dto
        ToDoListDTO dto = new ToDoListDTO();
        dto.setId(list.get().getId());
        dto.setListName(list.get().getName());
        dto.setTodos(todos);

        //Return DTO
        return dto;
    }
}
