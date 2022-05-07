import React, { Fragment, useContext, useEffect } from 'react'
import Store from '../Util/Store'
import Form from '../Form/Form'
import List from '../List/List'
const HOST_API = "http://localhost:8080/api";

const ListItem = () => {
  const { dispatch, state: { listtodo } } = useContext(Store);
  const currentList = listtodo.list;

  useEffect(() => {
    fetch(HOST_API + "/todoslist")
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "listtodo-list", list })
      })
  }, [dispatch]);

//Eliminar lista de listas
  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/todolist", {
      method: "DELETE"
    }).then((list) => {
      dispatch({ type: "delete-list", id })
    })
  };

  return (
    <Fragment>
      <div className='container text-center'>
        {currentList.map((element) => {
          return <div key={element.id} className="border my-5">
            <div  className="panel-body mx-sm-3" >
              <br />
              <span className="label label-primary">LISTAS DE ACTIVIDADES</span>
              <input
              className='form-control text-center'
                disabled={true}
                value={element.nameList} />
                
              <button
              className='btn btn-danger'
                onClick={() => onDelete(element.id)} >Eliminar
              </button>
            </div>
            <Form listId={element.id} />
            <List listId={element.id} />
          </div>
        })}
      </div>

    </Fragment>
  )
}

export default ListItem;