import useFetch from "../hooks/useFetch"

//TODO This version does not work at all!!!!!
const UpdateLinks = () => {

  const [links, error, isPending] = useFetch('http//localhost:8080/api/myuowm/links');

  const handleClick = (e) => {
    //TODO implement put request to server
  }

  return (
    <div className="links-update">
      {isPending && <div>Loading...</div>}
      {error && <div>{ error }</div>}
      <form>
        <label>Lesxi</label>
        <input
          type="url"
          value={ links.lesxi }
          required
          onChange={ (e) => (links.lesxi = e.target.value)}
        />
        <label>Eudoksos</label>
        <input
          type="url"
          value={ links.eudoksos }
          required
          onChange={ (e) => (links.eudoksos = e.target.value)}
        />
        {/* TODO add other links */}
        <button onClick={ () => handleClick(links) }>Submit</button>
      </form>
        
    </div>
  )
}

export default UpdateLinks
