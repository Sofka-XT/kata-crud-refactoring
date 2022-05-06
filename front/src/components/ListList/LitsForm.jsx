import React, { Fragment, useContext, useRef, useState } from 'react';
import Store from '../Util/Store'



const HOST_API = "http://localhost:8080/api";

const ListForm = () => {
  const formRef = useRef(null);
  const { dispatch, state: { listtodo } } = useContext(Store);
  const item = listtodo.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      nameList: state.nameList,
      id: null,
    };

    fetch(HOST_API + "/todolist", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((listtodo) => {
        dispatch({ type: "list-add", item: listtodo });
        setState({ nameList: "" });
        formRef.current.reset();
      });
  }

  return (
    <Fragment>
      <form ref={formRef}>
        <div className='form-group mx-sm-5'>
          <label  for="inputUser" className="sr-only">Nombre de la lista de tarea</label>
        <input
          className='form-control'
          type="text"
          name="name"
          placeholder="Lista de tareas"
          onChange={(event) => {
            setState({ ...state, nameList: event.target.value })
          }}  ></input>
        <br />
        <button className="btn btn-success" onClick={onAdd} >Crear</button>
        <br />
        </div>
          </form>

    </Fragment>
  )
}

export default ListForm;