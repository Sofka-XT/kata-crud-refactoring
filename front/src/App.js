import React, { Fragment } from "react";
/* import FormGroup from "./components/FormGroup"; */
import Todo from "./components/Todo";



function App() {
  return <Fragment>
<div className="container">
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
  <h3>DashBoard</h3>
  </div>
</nav>
  <Todo/>
  </div>
  </Fragment>
}

export default App;
