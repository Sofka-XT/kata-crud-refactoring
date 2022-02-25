import React from 'react'

import List from "./List";
import Form from "./Form";
import StoreProvider from "../StoreProvider/StoreProvider";
import FormGroup from './FormGroup';
import FormGroupList from './FormGroupList';

function Todo() {
    return (
      <StoreProvider>
      

    
<FormGroupList/>
<FormGroup/>
      </StoreProvider>
    );
  }

  export default Todo;