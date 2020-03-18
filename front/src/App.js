import React, { useContext, useReducer, useEffect, useRef, useState, createContext } from 'react';

const HOST_API = "http://localhost:8080/api";
const initialState = {
  todo: []
};
const Store = createContext(initialState)



const ListForm = () => {
  const { dispatch } = useContext(Store);
  const formRef = useRef(null);
  const [state, setState] = useState({});

  const onCreate = (event) => {
    event.preventDefault();
    dispatch({ type: "new-list", name: state.name });
    formRef.current.reset();
    setState({});
  };

  return <form ref={formRef}>
    <input
      type="text"
      name="name"
      placeholder="Lista de TO-DO"
      onChange={(event) => {
        setState({ ...state, name: event.target.value })
      }}  ></input>
    <button onClick={onCreate}>Nueva lista</button>
  </form>

};


const Form = ({ groupId }) => {
  const formRef = useRef(null);
  const { dispatch, state: { todo } } = useContext(Store);
  const item = todo[groupId].item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      groupListId: groupId,
      name: state.name,
      id: null,
      isCompleted: false
    };


    fetch(HOST_API + "/todo", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "add-item", item: todo, groupId });
        setState({ name: "" });
        formRef.current.reset();
      });
  }

  const onEdit = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      groupListId: groupId,
      id: item.id,
      isCompleted: item.isCompleted
    };


    fetch(HOST_API + "/todo", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo, groupId });
        setState({ name: "" });
        formRef.current.reset();
      });
  }

  return <form ref={formRef}>
    <input
      type="text"
      name="name"
      placeholder="¿Qué piensas hacer hoy?"
      defaultValue={item.name}
      onChange={(event) => {
        setState({ ...state, name: event.target.value })
      }}  ></input>
    {item.id && <button onClick={onEdit}>Actualizar</button>}
    {!item.id && <button onClick={onAdd}>Crear</button>}
  </form>
}

const GroupTodo = () => {
  const { state } = useContext(Store);
  return <ul>
    {state.todo.map((list, index) => {
      return <ol key={index}>
        <fieldset>
          <legend>{list.name}</legend>
          <Form {...list} groupId={index} />
          <List {...list} groupId={index} />
        </fieldset>
      </ol>
    })}
  </ul>
}

const List = ({ groupId }) => {
  const { dispatch, state: { todo } } = useContext(Store);
  const currentList = todo[groupId].list;

  useEffect(() => {
    fetch(HOST_API + "/" + groupId + "/todos")
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list, groupId })
      })
  }, [currentList.length, dispatch, groupId]);


  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/todo", {
      method: "DELETE"
    }).then((list) => {
      dispatch({ type: "delete-item", id, groupId })
    })
  };

  const onEdit = (todo) => {
    dispatch({ type: "edit-item", item: todo, groupId })
  };

  const onChange = (event, todo) => {
    const request = {
      name: todo.name,
      id: todo.id,
      groupId,
      completed: event.target.checked
    };
    fetch(HOST_API + "/todo", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
      });
  };

  const decorationDone = {
    textDecoration: 'line-through'
  };
  return <div>
    <table >
      <thead>
        <tr>
          <td>ID</td>
          <td>Tarea</td>
          <td>¿Completado?</td>
        </tr>
      </thead>
      <tbody>
        {currentList.map((todo) => {
          return <tr key={todo.id} style={todo.completed ? decorationDone : {}}>
            <td>{todo.id}</td>
            <td>{todo.name}</td>
            <td><input type="checkbox" defaultChecked={todo.completed} onChange={(event) => onChange(event, todo)}></input></td>
            <td><button onClick={() => onDelete(todo.id)}>Eliminar</button></td>
            <td><button onClick={() => onEdit(todo)}>Editar</button></td>
          </tr>
        })}
      </tbody>
    </table>
  </div>
}



function reducer(state, action) {
  switch (action.type) {
    case 'new-list':
      const todo = state.todo;
      todo.push({ name: action.name, item: {}, list: [] });
      return { ...state, todo }
    case 'update-item':
      const todoUpItem = state.todo;
      const newListUpdate = todoUpItem[action.groupId];
      const listUpdateEdit = newListUpdate.list.map((item) => {
        if (item.id === action.item.id) {
          return action.item;
        }
        return item;
      });
      newListUpdate.list = listUpdateEdit;
      newListUpdate.item = {};
      return { ...state, todo: todoUpItem }
    case 'delete-item':
      const todoUpDelete = state.todo;
      const newListDelete = todoUpDelete[action.groupId];
      const listUpdate = newListDelete.list.filter((item) => {
        return item.id !== action.id;
      });
      newListDelete.list = listUpdate;
      return { ...state, todo: todoUpDelete }
    case 'update-list':
      const todoUpList = state.todo;
      const newListList = todoUpList[action.groupId];
      newListList.list = action.list;
      return { ...state, todo: todoUpList }
    case 'edit-item':
      const todoUpEdit = state.todo;
      const newListEdit = todoUpEdit[action.groupId];
      newListEdit.item = action.item;
      return { ...state, todo: todoUpEdit }
    case 'add-item':
      const todoUp = state.todo;
      const newList = todoUp[action.groupId].list;
      newList.push(action.item);
      return { ...state, todo: todoUp }
    default:
      return state;
  }
}

const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  return <Store.Provider value={{ state, dispatch }}>
    {children}
  </Store.Provider>

}

function App() {
  return <StoreProvider>
    <ListForm />
    <GroupTodo />
  </StoreProvider>
}

export default App;
