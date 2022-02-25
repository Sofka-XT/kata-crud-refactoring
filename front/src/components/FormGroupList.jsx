import React, { useContext, useEffect } from 'react';
import Form  from './Form';
import { HOST_API } from "../common/HOST_API";
import { Store } from "../common/Store";
import  List   from './List';

const FormGroupList = () => {
    const { dispatch, state: { groupList } } = useContext(Store);
    const lista = groupList.list;
console.log(groupList)
    useEffect(() => {
        fetch(HOST_API + "/groupLists")
          .then(response => response.json())
          .then((list) => {
              console.log(list)
            dispatch({ type: "update-groupList", list });
          });
    }, [dispatch]);
    return (
        lista.map((groupList) => {
            return (
                <div>
                    <h2>{groupList.name}</h2>
                    <button>Eliminar</button>
                    <Form id={groupList} />
                    <List id={groupList} />
                </div>
            )
        })
    )
};

export default FormGroupList;