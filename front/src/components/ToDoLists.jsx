import React, { useEffect } from "react";
import { fetchListas, fetchApi } from "./GetFunctions";
import { ToDosItems } from "./ToDosItems";

export const ToDoLists = (props) => {
  const listas = props.Lists ? props.Lists : []
  useEffect(() => {
    fetchListas()
    .then((response) => response.json())
    .then((listas) => props.setLists(listas));
  }, [])

  if (listas) {
    return (
      <div>
        {listas.map((lista) => {
          return (
            <div key={lista.id}>
              <div>
                <h1>{lista.name}</h1>
                <button
                  className="btn btn-success m-3"
                  onClick={() => {
                    props.eliminarLista(lista);
                  }}
                >Eliminar</button>
              </div>
              {props.insertForm(lista)}
              {props.insertTodo(lista)}
            </div>
          );
        })}
      </div>
    );
  }
};
