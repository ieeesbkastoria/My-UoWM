import { useLinksContext } from '../hooks/useLinksContext'
import { useAuthContext } from '../hooks/useAuthContext'

// date fns
import formatDistanceToNow from 'date-fns/formatDistanceToNow'

const LinkDetails = ({ link }) => {
  const { dispatch } = useLinksContext()
  const { user } = useAuthContext()

  const handleClick = async () => {
    if (!user) {
      return
    }

    const response = await fetch('/api/links/' + link._id, {
      method: 'DELETE',
      headers: {
        'Authorization': `Bearer ${user.token}`
      }
    })
    const json = await response.json()

    if (response.ok) {
      dispatch({ type: 'DELETE_LINK', payload: json })
    }
  }

  return (
    <div className="link-details">
      <h4>{link.title}</h4>
      <p><strong>URL: </strong>{link.url}</p>
      <p>{formatDistanceToNow(new Date(link.createdAt), { addSuffix: true })}</p>
      <span className="material-symbols-outlined" onClick={handleClick}>delete</span>
    </div>
  )
}

export default LinkDetails
