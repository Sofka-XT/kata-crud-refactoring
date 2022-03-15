import React, { useEffect, useState } from "react";
import { fetchListas, fetchApi, fetchDTO } from "./GetFunctions";
import { ToDosItems } from "./ToDosItems";

export const ToDoLists = (props) => {
  const listas = props.Lists ? props.Lists : []
  const dtos = props.DTOS ? props.DTOS : [];
  const [Estado, setEstado] = useState(0);
  useEffect(() => {
    fetchListas()
    .then((response) => response.json())
    .then((list) => props.setLists(list))
    // .then((list) => {
    //   let arrayDTOS = []
    //   list.forEach(element => {
    //         // console.log(element.id)
    //     fetchDTO(element.id)
    //       .then((response) => response.json())
    //       .then((dto) => {
    //         arrayDTOS.push(dto)
    //       })
    //   })
    //   dtos.push(arrayDTOS)
    //   // props.setDTOS(arrayDTOS)
    // });

  }, [])

  if (listas) {
    return (
      <div>
        {listas.map(dto => {
          return (
            <div
              key={dto.id}
              className="border border-3 p-3 mb-2 bg-light text-dark"
            >
              <div className="d-flex flex-row bd-highlight mb-3 align-items-center">
                <h1>{dto.name}</h1>
                <button
                  className="btn btn-danger m-3"
                  onClick={() => {
                    props.eliminarLista(dto);
                  }}
                >
                  Eliminar
                </button>
              </div>
              {props.insertForm(dto)}
              {props.insertTodo(dto)}
            </div>
          );
        })}
      </div>
    );
  }
};
