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
              <h1>{lista.name}</h1>
              {props.insertTodo(lista)}
            </div>
          );
        })}
      </div>
    );
  }
};
