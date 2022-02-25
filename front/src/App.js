import React, { Fragment } from "react";
/* import FormGroup from "./components/FormGroup"; */
import Todo from "./components/Todo";



function App() {
  return <Fragment>
<div className="container">
<nav className="navbar navbar-light bg-light">
  <div className="container-fluid">
  <h3>DashBoard</h3>
  </div>
</nav><div>
  <Todo/>
  </div>
  </div>
  </Fragment>
}

export default App;
