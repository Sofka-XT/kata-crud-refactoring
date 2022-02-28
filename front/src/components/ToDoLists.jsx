import React, { useEffect } from "react";
import { fetchListas, fetchApi } from "./GetFunctions";
import { ToDosItems } from "./ToDosItems";

export const ToDoLists = (props) => {
  const listas = props.Lists ? props.Lists : []
  useEffect(() => {
    fetchListas()
    .then((response) => response.json())
    .then((list) => props.setLists(list));
  }, [])

  if (listas) {
    return (
      <div>
        {listas.map((lista) => {
          return (
            <div
              key={lista.id}
              className="border border-3 p-3 mb-2 bg-light text-dark"
            >
              <div className="d-flex flex-row bd-highlight mb-3 align-items-center">
                <h1>{lista.name}</h1>
                <button
                  className="btn btn-danger m-3"
                  onClick={() => {
                    props.eliminarLista(lista);
                  }}
                >
                  Eliminar
                </button>
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
