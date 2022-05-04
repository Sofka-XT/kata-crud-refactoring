package co.com.sofka.crud.service;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class TodoServiceTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    @DisplayName("Agregar Todo")
    public void guardarTodo() {

        //Arrange
        Todo todo = new Todo("Ir a cine", false, 1L);

        //Act
        Todo todoRegistrado = todoRepository.save(todo);

        //Assert
        assertNotNull(todoRegistrado);

    }

    @Test
    @DisplayName("Obtener por id")
    public void obtenerPorId() {
     //Arrange
        Long idBuscado = 1L;
     //Act
        Optional<Todo> todoModelBuscado = todoRepository.findById(idBuscado);
    // Assert
        assertThat(todoModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    @DisplayName("Listar todo")
    public void listarTodo(){
        //Arrange
        List<Todo> todoList = (List<Todo>) todoRepository.findAll();
        //Assert
        assertThat(todoList).size().isGreaterThan(0);
    }

    @Test
    @DisplayName("Eliminar todo")
    public void eliminarTodo(){
        //Arrange
        Long idTodo =1L;
        //Act
        boolean eliminarExistente = todoRepository.findById(idTodo).isPresent();
        todoRepository.deleteById(idTodo);
        boolean noExiste = todoRepository.findById(idTodo).isPresent();
        //Assert
        assertTrue(eliminarExistente);
        assertFalse(noExiste);
    }
}