import React, { createContext, useReducer } from 'react'
import  Reducer  from './Reduce';

const initialState = {
    todo: { list: [], item: {} },
    listtodo: {list:[], item: {}}
  };
const Store = createContext(initialState)

export const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(Reducer, initialState);
  return <Store.Provider value={{ state, dispatch }}>
      {children}
  </Store.Provider>
}

export default Store;