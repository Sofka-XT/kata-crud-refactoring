package co.com.sofka.crud.mapper;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.model.Todo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Autowired
    private ModelMapper mapper;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    public TodoDTO convertToDto(Todo todo){
        TodoDTO todoDto = mapper.map(todo, TodoDTO.class);
        todoDto.setId_todo(todo.getId_todo());
        todoDto.setName(todo.getName());
        todoDto.setCompleted(todo.isCompleted());
        todoDto.setId_groupList(todo.getId_groupList());
        return todoDto;
    }

    public Todo convertToEntity(TodoDTO todoDto){
        Todo todo = mapper.map(todoDto, Todo.class);

        if (todoDto.getId_todo() != null){
            todo.setId_todo(todoDto.getId_todo());
            todo.setName(todoDto.getName());
            todo.setCompleted(todoDto.isCompleted());
            todo.setId_groupList(todoDto.getId_groupList());
        }
        return todo;
    }
}