import React, { Fragment } from "react";
import { StoreProvider } from "./components/Util/Store";
import ListFrom from "./components/ListList/LitsForm";
import ListItem from "./components/ListList/ListItem";

function App() {
  return (
    <Fragment>
      <StoreProvider>
        <div className="container">
          <h1 className="display-6 text-center">Reto Desarrollo web</h1>
          <div className="panel panel-default border rounded ">
            <br />
            <div className="panel-body border rounded" >
              <h3 className="display-10 text-center">Crea una Lista de tareas</h3>
              <ListFrom />
            </div>
            <br />
          </div>
          <ListItem />
        </div>
      </StoreProvider>
    </Fragment>
  );
}

export default App;
