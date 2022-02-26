import React from 'react'

import StoreProvider from "../StoreProvider/StoreProvider";
import FormGroup from './FormGroup';
import FormGroupList from './FormGroupList';

function Todo() {
    return (
      <StoreProvider>
<FormGroup/>
<div id="putAlert"></div>
  <div className='row' id='rowD'>
  <FormGroupList/>
  </div>


      </StoreProvider>
    );
  }

  export default Todo;