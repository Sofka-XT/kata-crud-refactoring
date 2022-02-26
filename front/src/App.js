import React, { Fragment } from "react";
/* import FormGroup from "./components/FormGroup"; */
import Todo from "./components/Todo";

function App() {
  return (
    <Fragment>
      <div className="container">
        <nav className="navbar navbar-light bg-light rounded mb-2">
          <div className="container">
            <div className="centText">
              <h3>Bienvenido al organizador To-Do</h3>
            </div>
          </div>
        </nav>
        <div className="container">
          <Todo />
        </div>
      </div>
    </Fragment>
  );
}

export default App;
