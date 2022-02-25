import React, {useRef} from 'react';

export const ToDoForm = (props) => {
  const formRef = useRef(null)

  const onClick = (event, accion, toDo) => {
    const request = {
      name: formRef.current[0].value,
      id: toDo ? toDo.id : null,
      completed: toDo ? toDo.completed : false,
    };

    accion(request);
    formRef.current.reset();
  };


  return (
    <form ref={formRef}>
      <input
        type="text"
        name="name"
        placeholder="¿Qué piensas hacer hoy?"
        defaultValue={props.ToDoActual ? props.ToDoActual.name : ""}
      ></input>
      {props.ToDoActual && (
        <button
          onClick={(event) =>
            onClick(
              event.preventDefault,
              props.editarToDo,
              props.ToDoActual
            )
          }
        >Actualizar</button>
      )}
      {!props.ToDoActual && (
        <button
          onClick={(event) =>
            onClick(
              event.preventDefault,
              props.crearToDo
            )
          }
        >Crear</button>
      )}
    </form>
  );
}
