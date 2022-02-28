import React, {

} from "react";

import { ToDoForm } from "./components/ToDoForm";
import { ToDosItems } from "./components/ToDosItems";
import { ToDoLists } from "./components/ToDoLists";
import { ListForm } from "./components/ListForm";

export const urlApi = "http://localhost:8080/api";

function App() {

  const [Lists, setLists] = useState([]);
  const [ToDos, setToDos] = useState([]);
  const [DTOS, setDTOS] = useState([]);
  const [ToDoActual, setToDoActual] = useState();

    const crearToDo = async (toDo) => {
      try {
        await fetch(urlApi + "/todo", {
          method: "POST",
          body: JSON.stringify(toDo),
          headers: {
            "Content-Type": "application/json",
          },
        })
          .then((response) => response.json())
          .then((item) => setToDos([...ToDos, item]));

      } catch (error) {
        console.log(error);
      }
    };

    const crearLista = async (lista) => {
      try {
        await fetch(urlApi + "/todolist", {
          method: "POST",
          body: JSON.stringify(lista),
          headers: {
            "Content-Type": "application/json",
          },
        })
          .then((response) => response.json())
          .then((item) => setLists([...Lists, item]));
      } catch (error) {
        console.log(error);
      }
    };

    const actualizarToDo = async (toDo) => {
      try {
        await fetch(urlApi + "/todo", {
          method: "PUT",
          body: JSON.stringify(toDo),
          headers: {
            "Content-Type": "application/json",
          },
        });

        setToDos(
          ToDos.map((element) => (element.id === toDo.id ? toDo : element))
        );

      } catch (error) {
        console.log(error);
      }
    };

    const editarToDo = async (toDo) => {
      try {
        await fetch(urlApi + "/todo", {
          method: "PUT",
          body: JSON.stringify(toDo),
          headers: {
            "Content-Type": "application/json",
          },
        });

        setToDos(
          ToDos.map((element) => (element.id === toDo.id ? toDo : element))
        );
        setToDoActual(undefined)

      } catch (error) {
        console.log(error);
      }
    };

  const eliminarToDo = async (toDo) => {
    try {
      await fetch(urlApi + "/" + toDo.id + "/todo", {
        method: "DELETE",
        body: JSON.stringify(toDo),
        headers: {
          "Content-Type": "application/json",
        },
      });

      setToDos(ToDos.filter((element) => element.id !== toDo.id))

    } catch (error) {
      console.log(error);
    }
  };

    const eliminarLista = async (lista) => {
      try {
        await fetch(urlApi + "/" + lista.id + "/todolist", {
          method: "DELETE",
          body: JSON.stringify(lista),
          headers: {
            "Content-Type": "application/json",
          },
        });

        setLists(Lists.filter((element) => element.id !== lista.id));
      } catch (error) {
        console.log(error);
      }
    };

  const insertTodo = (lista) => {
    return (
      <ToDosItems
        ToDos={ToDos}
        setToDos={setToDos}
        urlApi={urlApi}
        actualizarToDo={actualizarToDo}
        eliminarToDo={eliminarToDo}
        setToDoActual={setToDoActual}
        lista={lista}
      />
    );
  }

  const insertForm = (lista) => {
    return (
      <ToDoForm
        crearToDo={crearToDo}
        ToDoActual={ToDoActual}
        editarToDo={editarToDo}
        lista={lista}
      />
    );
  }

  return (
    <div>
      <h3>To-Do List</h3>
      <div className="">
        <ListForm crearLista={crearLista} />
        <ToDoLists
          Lists={Lists}
          setLists={setLists}
          ToDos={ToDos}
          setToDos={setToDos}
          urlApi={urlApi}
          actualizarToDo={actualizarToDo}
          eliminarToDo={eliminarToDo}
          setToDoActual={setToDoActual}
          insertTodo={insertTodo}
          insertForm={insertForm}
          eliminarLista={eliminarLista}
          DTOS={DTOS}
          setDTOS={setDTOS}
        ></ToDoLists>
      </div>
    </div>
  );
}

export default App;
