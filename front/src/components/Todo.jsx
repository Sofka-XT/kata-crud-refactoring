import React from 'react'

import StoreProvider from "../StoreProvider/StoreProvider";
import FormGroup from './FormGroup';
import FormGroupList from './FormGroupList';

function Todo() {
    return (
      <StoreProvider>
<FormGroup/>
<div className='container'>
  <div className='row' id='rowD'>
  <FormGroupList/>
  </div>
</div>

      </StoreProvider>
    );
  }

  export default Todo;