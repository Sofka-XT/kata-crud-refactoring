import React, { useEffect } from "react";
import { fetchListas, fetchApi } from "./GetFunctions";

export const ToDoLists = (props) => {
  const listas = props.Lists ? props.Lists : []
  useEffect(() => {
    fetchListas()
    .then((response) => response.json())
    .then((listas) => props.setLists(listas));
  }, [])
    const ToDos = props.ToDos ? props.ToDos : [];

  useEffect(() => {
    fetchApi()
      .then((response) => response.json())
      .then((items) => props.setToDos(items));
  }, []);

    const decorationDone = {
      textDecoration: "line-through",
    };

    const onChange = (event, toDo) => {
      const request = {
        name: toDo.name,
        id: toDo.id,
        completed: event.target.checked,
      };

      props.actualizarToDo(request);
    };

    const onClick = (item, accion) => {
      accion(item);
    };

  if (listas) {
    return (
      <div>
        {listas.map((element) => {
          return (
            <div key={element.id}>
              <h1>{element.name}</h1>
              <div>
                <table className="table table-borderless">
                  <thead>
                    <tr>
                      <td>ID</td>
                      <td>Tarea</td>
                      <td className="text-center">¿Completado?</td>
                    </tr>
                  </thead>
                  <tbody>
                    {ToDos.map((toDo) => {
                      if (toDo.toDoList == element.id) {
                        return (
                          <tr
                            className="align-middle"
                            key={toDo.id}
                            style={toDo.completed ? decorationDone : {}}
                          >
                            <td>{toDo.id}</td>
                            <td>{toDo.name}</td>
                            <td className="form-check form-switch d-flex align-items-center justify-content-center">
                              <input
                                className="form-check-input align-self-center"
                                type="checkbox"
                                defaultChecked={toDo.completed}
                                onChange={(event) => onChange(event, toDo)}
                              ></input>
                            </td>
                            <td>
                              <button
                                className="btn btn-danger"
                                onClick={() =>
                                  onClick(toDo, props.eliminarToDo)
                                }
                              >
                                Eliminar
                              </button>
                            </td>
                            <td>
                              <button
                                className="btn btn-primary"
                                onClick={() =>
                                  onClick(toDo, props.setToDoActual)
                                }
                              >
                                Editar
                              </button>
                            </td>
                          </tr>
                        );
                      }
                    })}
                  </tbody>
                </table>
              </div>
            </div>
          );
        })}
      </div>
    );
  }
};
