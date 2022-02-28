import React, { useEffect } from "react";
import { fetchListas, fetchApi, fetchDTO } from "./GetFunctions";
import { ToDosItems } from "./ToDosItems";

export const ToDoLists = (props) => {
  const listas = props.Lists ? props.Lists : []
  const dtos = props.DTOS ? props.DTOS : []
  useEffect(() => {
    fetchListas()
    .then((response) => response.json())
    .then((list) => {
      let arrayDTOS = []
      list.forEach(element => {
            console.log(element.id)
        fetchDTO(element.id)
          .then((response) => response.json())
          .then((dto) => {
            arrayDTOS.push(dto)
          });
      });
      props.setDTOS(arrayDTOS);
    })

  }, [])

  console.log(dtos);
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
