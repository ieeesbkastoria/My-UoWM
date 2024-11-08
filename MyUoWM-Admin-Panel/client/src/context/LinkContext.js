import { createContext, useReducer } from 'react'

export const LinksContext = createContext()

export const linksReducer = (state, action) => {
  switch (action.type) {
    case 'SET_LINKS':
      return {
        links: action.payload
      }
    case 'CREATE_LINK':
      return {
        links: [action.payload, ...state.links]
      }
    case 'DELETE_LINK':
      return {
        links: state.links.filter((l) => l._id !== action.payload._id)
      }
    default:
      return state
  }
}

export const LinksContextProvider = ({ children }) => {
  const [state, dispatch] = useReducer(linksReducer, {
    links: null
  })

  return (
    <LinksContext.Provider value={{ ...state, dispatch }}>
      {children}
    </LinksContext.Provider>
  )
}
