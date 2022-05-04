package co.com.sofka.crud.service;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.models.TodoList;
import co.com.sofka.crud.repository.TodoListRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class TodoListServiceTest {

    @Autowired
    private TodoListRepository todoListRepository;

    @Test
    @DisplayName("Agregar Todo")
    void listTodos() {
        //Arrange
        List<TodoList> todoListlist = (List<TodoList>) todoListRepository.findAll();
        //Assert
        assertThat(todoListlist).size().isGreaterThan(0);
    }

    @Test
    @DisplayName("Agregar ListaTodo")
    void saveLista() {

        //Arrange
        TodoList todolist = new TodoList("Sofka");

        //Act
        TodoList todoRegistrado = todoListRepository.save(todolist);

        //Assert
        assertNotNull(todoRegistrado);

    }

    @Test
    @DisplayName("Eliminar Lista Todo")
    void deleteList() {
        //Arrange
        Long idTodo =1L;
        //Act
        boolean eliminarExistente = todoListRepository.findById(idTodo).isPresent();
        todoListRepository.deleteById(idTodo);
        boolean noExiste = todoListRepository.findById(idTodo).isPresent();
        //Assert
        assertTrue(eliminarExistente);
        assertFalse(noExiste);
    }

    @Test
    @DisplayName("Obtener  ListTodo por id")
    void obtenerPorId() {
            //Arrange
            Long idBuscado = 1L;
            //Act
            Optional<TodoList> todoListModelBuscado = todoListRepository.findById(idBuscado);
            // Assert
            assertThat(todoListModelBuscado.get().getIdList()).isEqualTo(idBuscado);

    }
}