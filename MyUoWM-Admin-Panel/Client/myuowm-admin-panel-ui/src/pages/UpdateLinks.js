import useFetch from "../hooks/useFetch"

//TODO This version does not work at all!!!!!
const UpdateLinks = () => {

  const [links, error, isPending] = useFetch('http//localhost:8080/api/myuowm/links');

  const handleClick = (e) => {}

  return (
    <div className="links-update">
      {isPending && <div>Loading...</div>}
      {error && <div>{ error }</div>}
        
    </div>
  )
}

export default UpdateLinks
