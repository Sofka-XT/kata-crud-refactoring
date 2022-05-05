import React, { createContext, useReducer } from 'react'
import { reducer } from './Reduce';

const initialState = {
    todo: { list: [], item: {} }
};


const Store = createContext(initialState)


 export const  StoreProvider = ({ children }) => {
    const [state, dispatch] = useReducer(reducer, initialState);

    return <Store.Provider value={{ state, dispatch }}>
        {children}
    </Store.Provider> 

}

export default Store