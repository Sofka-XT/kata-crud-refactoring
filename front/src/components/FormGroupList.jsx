import React, { Fragment, useContext, useEffect } from "react";
import Form from "./Form";
import { HOST_API } from "../common/HOST_API";
import { Store } from "../common/Store";
import List from "./List";

const FormGroupList = () => {
  const {
    dispatch,
    state: { groupList },
  } = useContext(Store);
  const lista = groupList.list;

  useEffect(() => {
    fetch(HOST_API + "/groupLists")
      .then((response) => response.json())
      .then((list) => {
        dispatch({ type: "update-groupList", list });
      });
  }, [dispatch]);

  const onDelete = (id_groupList) => {
    fetch(HOST_API + "/" + id_groupList + "/groupList", {
      method: "DELETE",
    }).then((list) => {
      dispatch({ type: "delete-groupList", id_groupList });
    });
    //borro todo el div, x alguna razon no lo elimina sin el:
    document.getElementById(id_groupList).innerHTML=""
  };

  return lista.map((groupList) => {
    return (
      <Fragment key={groupList.id_groupList}>
        {/* los elementos como los div repetidos en iteracion, tienen que tener keys sino ERROR en consola. */}
        <div id={groupList.id_groupList} key={groupList.id_groupList}>
          <h2>{groupList.name}</h2>
          <button onClick={() => onDelete(groupList.id_groupList)}>
            Eliminar
          </button>
          <Form id={groupList} />
          <List id={groupList} />
        </div>
      </Fragment>
    );
  });
};

export default FormGroupList;
