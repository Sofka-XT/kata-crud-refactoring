import React, {useEffect} from 'react'
import { fetchApi } from "./GetFunctions";

export const ToDosItems = (props) => {
  const ToDos = props.ToDos ? props.ToDos : []

  useEffect(() => {
    fetchApi()
    .then(response => response.json())
    .then(items => props.setToDos(items))
  }, [])

  const decorationDone = {
    textDecoration: "line-through",
  };

  const onChange = (event, toDo, lista) => {
    const request = {
      name: toDo.name,
      id: toDo.id,
      completed: event.target.checked,
      toDoList: lista.id
    };

    props.actualizarToDo(request);
  };

  const onClick = (item, accion) => {
    accion(item);
  };

    if (ToDos) {
      return (
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
                if (toDo.toDoList == props.lista.id) {
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
                          onChange={(event) => onChange(event, toDo, props.lista)}
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
      );
    }
}
