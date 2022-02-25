import React from 'react'

export const ToDoList = (props) => {
  const ToDos = props.ToDos ? props.ToDos : []

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
                  <input type="checkbox" defaultChecked={toDo.completed} onChange={(event)=> console.log(event)}
                  ></input>
                </td>
                <td>
                  <button onClick={() => {console.log("Eliminar")}}>Eliminar</button>
                </td>
                <td>
                  <button onClick={() => {console.log("Editar")}}>Editar</button>
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
