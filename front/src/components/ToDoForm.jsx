import React, {useRef} from 'react';

export const ToDoForm = (props) => {
  const formRef = useRef(null)

  const onClick = (event, toDoName, accion) => {
    const request = {
      name: toDoName,
      id: null,
      completed: false,
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
        defaultValue=""
      ></input>
      {/* {item.id && <button onClick={onEdit}>Actualizar</button>} */}
      <button onClick={(event) => onClick(
        event.preventDefault,
        formRef.current[0].value,
        props.crearToDo
      )}>
        Crear
      </button>
    </form>
  );
}
