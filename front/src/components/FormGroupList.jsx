import React, { useContext, useEffect } from 'react';
import { Form } from './Form';
import { HOST_API } from "../common/HOST_API";
import { Store } from "../common/Store";
import { List }  from './List';

const FormGroupList = () => {
    const { dispatch, state: { categoryList } } = useContext(Store);
    const lista = categoryList.list;

    useEffect(() => {
        fetch(HOST_API + "/groupLists")
          .then(response => response.json())
          .then((list) => {
            dispatch({ type: "add-groupList", list: list });
          });
    }, [dispatch]);
  
    return (
        lista.map((groupList) => {
            return (
                <div key={groupList.id_groupList}>
                    <h2>{groupList.name}</h2>
                    <button>Eliminar</button>
                    <Form id={groupList.id_groupList} />
                    <List id={groupList.id_groupList} listCategory={groupList.todos}/>
                </div>
            )
        })
    )
};

export default FormGroupList;