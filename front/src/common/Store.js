import { createContext } from "react";

export const initialState = {
  todo: { list: [], item: {} },
  groupList : { list: [], item: {} }
};
export const Store = createContext(initialState);
