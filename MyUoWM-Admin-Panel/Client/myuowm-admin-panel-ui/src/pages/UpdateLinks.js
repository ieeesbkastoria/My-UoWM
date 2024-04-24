import useFetch from "../hooks/useFetch"

//TODO This version does not work at all!!!!!
const UpdateLinks = () => {

  const [links, error, isPending] = useFetch('http//localhost:8080/api/myuowm/links');

  const handleClick = (e) => {}

  return (
    <div className="update-link">
      <form>
        <label>Chose Link:</label>
        <select id="links" name="links">
          <option value="1">Lesxi</option>
          <option value="2">Other</option>
        </select>
        <input type="text" value="" required/>
        <button onClick={ handleClick } >Submit</button>
      </form>
    </div>
  )
}

export default UpdateLinks
