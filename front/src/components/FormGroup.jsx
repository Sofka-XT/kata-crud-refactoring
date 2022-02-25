import React, { useContext, useRef, useState } from "react";
import { HOST_API } from "../common/HOST_API";
import { Store } from "../common/Store";

const FormGroup = () => {
  const formRef = useRef(null);
  const {
    dispatch,
    state: { groupList },
  } = useContext(Store);
  const item = groupList.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id_groupList: null,
    };
  
    if (state.name === "" || state.name === undefined) {
      alert("Tiene que ingresar nombre de Lista")
    } else {
      if (state.name.trim().length === 0) {
       alert("Tiene que ingresar nombre de Lista")
      } else {
        fetch(HOST_API + "/groupList", {
          method: "POST",
          body: JSON.stringify(request),
          headers: {
            "Content-Type": "application/json",
          },
        })
          .then((response) => response.json())
          .then((groupList) => {
            dispatch({ type: "add-groupList", item: groupList });
            setState({ name: "" });
            formRef.current.reset();
          });
      }
    }
  };
  return (
    <div className="row">
      <p className="placeholder-glow">
        <span className="placeholder col-12"></span>
      </p>

      <div className="col-2"></div>
      <div className="col -8">
        <form ref={formRef}>
          <div className="input-group mb-3">
            <input
              type="text"
              name="name"
              placeholder="Lista TO-DO"
              className="form-control"
              onChange={(event) => {
                setState({ ...state, name: event.target.value });
              }}
            ></input>

            <button onClick={onAdd} className="btn btn-outline-secondary">
              Agregar Nueva Lista de tareas:
            </button>
          </div>
        </form>
      </div>
      <div className="col-2"></div>
      <p className="placeholder-glow">
        <span className="placeholder col-12"></span>
      </p>
    </div>
  );
};

export default FormGroup;
