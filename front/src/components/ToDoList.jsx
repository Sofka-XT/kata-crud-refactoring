import React from 'react'

export const ToDoList = (props) => {
  const ToDos = props.ToDos ? props.ToDos : []

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

    if (ToDos) {
      return (
        <div>
          <table>
            <thead>
              <tr>
                <td>ID</td>
                <td>Tarea</td>
                <td>¿Completado?</td>
              </tr>
            </thead>
            <tbody>
              {ToDos.map((toDo) => {
              return (
              <tr key={toDo.id}>
                <td>{toDo.id}</td>
                <td>{toDo.name}</td>
                <td>
                  <input type="checkbox" defaultChecked={toDo.completed} onChange={(event) => onChange(event, toDo)}
                  ></input>
                </td>
                <td>
                  <button onClick={() => onClick(toDo, props.eliminarToDo)}>Eliminar</button>
                </td>
                <td>
                  <button onClick={() => onClick(toDo, props.setToDoActual)}>Editar</button>
                </td>
              </tr>
              );
              })}
            </tbody>
          </table>
        </div>
      );
    }
}
