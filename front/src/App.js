import React from 'react';
import { List } from './components/List/List';
import {Form} from './components/Form/Form';
import {StoreProvider} from './components/Util/Store'

function App() {
  return <StoreProvider>
    <h3>To-Do List</h3>
    <Form />
    <List />
  </StoreProvider>
}

export default App;
