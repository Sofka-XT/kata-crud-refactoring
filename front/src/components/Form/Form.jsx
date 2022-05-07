import React, { useRef, useContext, useState, Fragment } from 'react'
import Store from '../Util/Store'

const HOST_API = "http://localhost:8080/api";

//Componente Form
const Form = ({ listId }) => {
  //usando los hooks
  const formRef = useRef(null);
  const { dispatch, state: { todo } } = useContext(Store);
  const item = todo.item;
  const [state, setState] = useState(item);

  //funcion para añadir elemento
  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: null,
      completed: false,
      groupListId: listId
    };


    fetch(HOST_API + "/todo", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "add-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  }

//Funcion para eliminar todo
  const onEdit = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: item.id,
      isCompleted: item.isCompleted,
      groupListId: listId
    };


    fetch(HOST_API + "/todo", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  }

  return (<Fragment>
    <form ref={formRef}>
      <br/>
      <div className='form-group mx-sm-5'>
      <input
        className='form-control'
        type="text"
        name="name"
        placeholder="¿Qué piensas hacer hoy?"
        defaultValue={item.name}
        onChange={(event) => {
          setState({ ...state, name: event.target.value })
        }}  ></input>
      {item.id && <button className="btn btn-success" onClick={onEdit}>Actualizar</button>}
      {!item.id && <button className="btn btn-success" onClick={onAdd}>Crear</button>}
   
      </div>
       </form>
  </Fragment>
  );
}

export default Form;