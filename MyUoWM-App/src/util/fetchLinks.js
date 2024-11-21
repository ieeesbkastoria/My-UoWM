import { useEffect } from 'react'
import { useLinksContext } from "../hooks/useLinksContext"

export const fetchLinks = async () => {
  const { links, dispatch } = useLinksContext()

  useEffect(() => {
    const fetchLinks = async () => {
      const response = await fetch('/api/links')
      const json = await response.json()

      if (response.ok) {
        dispatch({ type: 'SET_LINKS', payload: json })
      }
    }

    if (user) {
      fetchLinks()
    }
  }, [dispatch, user])

  return links;
}
