import React, {useRef} from 'react';

export const ToDoForm = (props) => {
  const formRef = useRef(null)

  const handleSubmit = (event) => {
    event.preventDefault()
    const string = formRef.current[0].value;

    if (string.length > 2) {

      const request = {
        name: string,
        id: props.ToDoActual ? props.ToDoActual.id : null,
        completed: props.ToDoActual ? props.ToDoActual.completed : false,
      };

      props.ToDoActual ? props.editarToDo(request) : props.crearToDo(request);
      formRef.current.reset();
    } else {
      alert("El nombre es muy corto")
    }

  };


  return (
    <form ref={formRef} onSubmit={handleSubmit}>
      <input
        className="p-1"
        type="text"
        name="name"
        placeholder="¿Qué piensas hacer hoy?"
        defaultValue={props.ToDoActual ? props.ToDoActual.name : ""}
        required
      ></input>
      <button type="submit" className="btn btn-success m-3">
        {props.ToDoActual ? "Actualizar" : "Crear"}
      </button>
    </form>
  );
}
