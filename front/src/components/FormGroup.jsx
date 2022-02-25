import React, { useContext, useRef, useState } from 'react';
import { HOST_API } from '../common/HOST_API';
import { Store } from "../common/Store";

const FormGroup = () => {
  const formRef = useRef(null);
  const { dispatch, state: { groupList } } = useContext(Store);
  const item = groupList.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
        name: state.name,
        id_groupList: null
    };

    fetch(HOST_API + "/groupList", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((groupList) => {
        dispatch({ type: "add-groupList", item: groupList });
        setState({ name: "" });
        formRef.current.reset();
      });
  };
  
  return (
    <div>
        <form ref={formRef}>
            <input
                type="text"
                name="name"
                placeholder="Lista TO-DO"
                onChange={(event) => {
                    setState({ ...state, name: event.target.value });
            }}>
            </input>
            <button onClick={onAdd}>Agregar Nueva Lista de tareas:</button>
            </form>
    </div>
  )
};

export default FormGroup;