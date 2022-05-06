import React, { useContext, useRef, useState } from 'react';
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
        'Content-Type':'application/json'
      }
    })
      .then(response => response.json())
      .then((listtodo) => {
        dispatch({ type: "list-add", item: listtodo });
        setState({ nameList: "" });
        formRef.current.reset();
      });
  }

  return <form ref={formRef} className="form">
    <input
      type="text"
      name="name"
      placeholder="Nombre de la categoria"
      onChange={(event) => {
        setState({ ...state, nameList: event.target.value })
      }}  ></input>
    <br />
    <button onClick={onAdd} >Crear</button>
    <br />
  </form>
}

export default ListForm;