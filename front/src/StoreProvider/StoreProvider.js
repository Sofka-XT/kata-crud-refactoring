import React, { useReducer } from "react";
import { initialState, Store } from "../common/Store";
import reducer from "../reducer/reducer"


const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <Store.Provider value={{ state, dispatch }}>{children}</Store.Provider>
  );
};

export default StoreProvider;
