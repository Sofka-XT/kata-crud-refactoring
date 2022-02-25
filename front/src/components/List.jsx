import React, {
    useContext,
    useEffect
  } from "react";
import {HOST_API} from "../common/HOST_API"
import {Store} from "../common/Store"


const List = ({id}) => {
    
    const {
      dispatch,
      state: { todo },
    } = useContext(Store);
    console.log(todo.list)
    const currentList = todo.list;
  
const toShow = currentList.filter(e => e.id_groupList === id.id_groupList)
console.log(toShow)

    useEffect(() => {
      fetch(HOST_API + "/todos")
        .then((response) => response.json())
        .then((list) => {
            console.log(list)
          dispatch({ type: "update-list", list });
        });
    }, [dispatch]);
    
    const onDelete = (id_todo) => {
      fetch(HOST_API + "/" + id_todo + "/todo", {
        method: "DELETE",
      }).then((list) => {
        dispatch({ type: "delete-item", id_todo });
      });
    };
  
    const onEdit = (todo) => {
      dispatch({ type: "edit-item", item: todo });
    };
  
    const onChange = (event, todo) => {
      const request = {
        name: todo.name,
        id_todo: todo.id_todo,
        completed: event.target.checked,
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
        });
    };
  
//funcion que me devuelve si campo nombre esta completado.
const btnTurn = (param) => param? true : false;

    const decorationDone = {
      textDecoration: "line-through",
    };
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
              
            {toShow.map((todo) => {
              return (
                <tr key={todo.id_todo} style={todo.completed ? decorationDone : {}}>
                  <td>{todo.id_todo}</td>
                  <td>{todo.name}</td>
                  <td>
                    <input
                      type="checkbox"
                      defaultChecked={todo.completed}
                      onChange={(event) => onChange(event, todo)}
                    ></input>
                  </td>
                  <td>
                    <button onClick={() => onDelete(todo.id_todo)}>Eliminar</button>
                  </td>
                  <td>
                    <button disabled={btnTurn(todo.completed)} onClick={() => onEdit(todo)}>Editar</button>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    );
  };

  export default List;