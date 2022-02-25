import React, {
    useContext,
    useRef,
    useState
  } from "react";
import {HOST_API} from "../common/HOST_API"
import {Store} from "../common/Store"


const Form = ({id}) => {
    const formRef = useRef(null);
    const {
      dispatch,
      state: { todo },
    } = useContext(Store);
    const item = todo.item;
    const [state, setState] = useState(item);
  
    const onAdd = (event) => {
      event.preventDefault();
  
      const request = {
        name: state.name,
        id_todo: null,
        completed: false,
        id_groupList: id.id_groupList
      };

      fetch(HOST_API + "/todo", {
        method: "POST",
        body: JSON.stringify(request),
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((response) => response.json())
        .then((todo) => {
          dispatch({ type: "add-item", item: todo });
          setState({ name: "" });
          formRef.current.reset();
        });
    };
  
    const onEdit = (event) => {
      event.preventDefault();
  
      const request = {
        name: state.name,
        id: item.id,
        isCompleted: item.isCompleted,
        id_groupList: item.id_groupList
      };
  
      fetch(HOST_API + "/todo", {
        method: "PUT",
        body: JSON.stringify(request),
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((response) => response.json())
        .then((todo) => {
          dispatch({ type: "update-item", item: todo });
          setState({ name: "" });
          formRef.current.reset();
        });
    };
  
    //funcion que me devuelve si campo nombre esta completado.
    const noName = (name) => name === undefined || name.length === 0 ?true:false;
      

    return (
      <div className="container mt-2">
      <div className="row">
        <div className="col mb-3">
      <form ref={formRef}>
        <div className="input-group">
        <input
        className="form-control"
          type="text"
          name="name"
          placeholder="¿Qué piensas hacer hoy?"
          defaultValue={item.name}
          onChange={(event) => {
            setState({ ...state, name: event.target.value });
          }}
        ></input>
        <div>
        {item.id_todo && <button type="button" className="btn btn-secondary" onClick={onEdit}>Actualizar</button>}
        {!item.id_todo && <button className="btn btn-secondary" disabled={noName(state.name)} onClick={onAdd}>Crear</button>}
        </div>
        </div>
      </form>
      </div>
      <div className="col"></div>
      
      
      </div>
      </div>
    );
  };


export default Form;