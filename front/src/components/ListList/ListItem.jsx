import React, { useContext, useEffect } from 'react'
import Store from '../Util/Store'
import Form from '../Form/Form'
import List from '../List/List'

const HOST_API = "http://localhost:8080/api";

const ListItem = () => {
    const { dispatch, state: { listtodo  } } = useContext(Store);
    const currentList = listtodo.list;
  
    useEffect(() => {
      fetch(HOST_API + "/todoslist")
        .then(response => response.json())
        .then((list) => {
          dispatch({ type: "listtodo-list", list })
        })
    }, [dispatch]);
  
  
    const onDelete = (id) => {
      fetch(HOST_API + "/" + id + "/todolist", {
        method: "DELETE"
      }).then((list) => {
        dispatch({ type: "delete-list", id })
      })
    };
  
    return <div>
      {currentList.map((element) =>{
        return<div key={element.id} >
        <div >
            <span >Lista de tareas</span>
            <input   
            disabled={true} 
            value={element.nameList} />
            <button
            onClick={() => onDelete(element.id)} >Eliminar
            </button>
        </div>
        <Form listId={element.id} />
        <List listId={element.id} />
    </div>
      })}
  </div>
}

export default ListItem;