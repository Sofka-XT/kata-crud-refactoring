import React from 'react'

import List from "./List";
import Form from "./Form";
import StoreProvider from "../StoreProvider/StoreProvider";

function Todo() {
    return (
      <StoreProvider>
        <h3>To-Do List</h3>
        <Form/>
        <List />
      </StoreProvider>
    );
  }

  export default Todo;