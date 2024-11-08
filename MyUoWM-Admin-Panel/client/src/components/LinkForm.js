import { useState } from "react"
import { useLinksContext } from "../hooks/useLinksContext"
import { useAuthContext } from '../hooks/useAuthContext'

const LinkForm = () => {
  const { dispatch } = useLinksContext()
  const { user } = useAuthContext()

  const [title, setTitle] = useState('')
  const [url, setUrl] = useState('')
  const [error, setError] = useState(null)
  const [emptyFields, setEmptyFields] = useState([])

  const handleSubmit = async (e) => {
    e.preventDefault()

    if (!user) {
      setError('You must be logged in')
      return
    }

    const link = { title, url }

    const response = await fetch('/api/links', {
      method: 'POST',
      body: JSON.stringify(link),
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${user.token}`
      }
    })
    const json = await response.json()

    if (!response.ok) {
      setError(json.error)
      setEmptyFields(json.emptyFields)
    }
    if (response.ok) {
      setTitle('')
      setUrl('')
      setError(null)
      setEmptyFields([])
      dispatch({ type: 'CREATE_LINK', payload: json })
    }
  }

  return (
    <form className="create" onSubmit={handleSubmit}>
      <h3>Add a New Hyperlink</h3>

      <label>Title:</label>
      <input
        type="text"
        onChange={(e) => setTitle(e.target.value)}
        value={title}
        className={emptyFields.includes('title') ? 'error' : ''}
      />

      <label>Url:</label>
      <input
        type="url"
        onChange={(e) => setUrl(e.target.value)}
        value={url}
        className={emptyFields.includes('url') ? 'error' : ''}
      />

      <button>Add Hyperlink</button>
      {error && <div className="error">{error}</div>}
    </form>
  )
}

export default LinkForm
