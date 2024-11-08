import { LinksContext } from '../context/LinkContext'
import { useContext } from 'react'

export const useLinksContext = () => {
  const context = useContext(LinksContext)

  if (!context) {
    throw Error('useLinksContext must be used inside an LinksContextProvider')
  }

  return context
}
