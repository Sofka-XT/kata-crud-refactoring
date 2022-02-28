import { urlApi } from "../App";

export const fetchListas = async () => {
  try {
    return await fetch(urlApi + "/todolists")
  } catch (error) {
    console.log(error);
  }
};

export const fetchApi = async (id) => {
  try {
    return await fetch(urlApi + `/todos`);
  } catch (error) {
    console.log(error);
  }
};

export const fetchDTO = async (id) => {
  try {
    return await fetch(urlApi + `/${id}/list`);
  } catch (error) {
    console.log(error);
  }
};
