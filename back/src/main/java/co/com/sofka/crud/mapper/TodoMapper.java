package co.com.sofka.crud.mapper;



import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.model.Todo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    @Mappings({
            @Mapping(source = "name", target = "nameDTO"),
            @Mapping(source = "completed", target = "completedDTO"),
            @Mapping(source = "idGroupList", target = "identificator")
    })
    TodoDTO toTodoDTO (Todo todo);
    Iterable<TodoDTO> toTodoDTOs (Iterable<Todo> todos);

    @InheritInverseConfiguration
    Todo toTodo(TodoDTO todoDTO);
}