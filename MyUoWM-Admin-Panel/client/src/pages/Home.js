import { useEffect } from 'react'
import { useLinksContext } from "../hooks/useLinksContext"
import { useAuthContext } from "../hooks/useAuthContext"

// components
import LinkDetails from '../components/LinkDetails'
import LinkForm from '../components/LinkForm'

const Home = () => {
  const { links, dispatch } = useLinksContext()
  const { user } = useAuthContext()

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

  return (
    <div className="home">
      <div className="links">
        {links && links.map((link) => (
          <LinkDetails key={link._id} link={link} />
        ))}
      </div>
      <LinkForm />
    </div>
  )
}

export default Home
