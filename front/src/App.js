import React from "react";
import { StoreProvider } from "./components/Util/Store";
import ListFrom from "./components/ListList/LitsForm";
import ListItem from "./components/ListList/ListItem";

function App() {
  return (
    <StoreProvider>
       <h1>Reto Desarrollo web</h1>
    <div>
      <br />
      <div>
        <h3>Crea una Lista de tareas</h3>
        <ListFrom/>
      </div>
      <br />
    </div>
    <ListItem/>
    </StoreProvider>
  );
}

export default App;
