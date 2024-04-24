import useFetch from "../hooks/useFetch"

const UpdateClub = () => {
  const [clubs, error, isPending] = useFetch('http//localhost:8080/myuowm/clubs');

  //TODO const clubs = ... is WRONG
  const handleClick = (e) => {
    e.preventDefault();
    const clubs = {clubs};

    fetch('http://localhost:8080/admin/clubs', {
      method: 'PUT',
      header: {"Content-Type": "application/json",},
      body: JSON.stringify(clubs),
    })
      .then(() => {
        console.log("Club updated");
      })
      .catch((e) => {
        console.log(JSON.stringify(clubs))
        console.log("Couldn't update clubs" + e);
      })
  }

  return (
    <div className="club-update">
      { isPending && <div>Loading...</div> }
      { error && <div>{ error }</div> }
      { clubs && clubs.map(club => (
        <form>
          <label>Name</label>
          <input type="text" value={ club.name } required onChange = {(e) => club.name = e.target.value } />
          <label> Link </label>
          <input type="text" value={ club.link } required onChange = {(e) => club.link = e.target.value } />
          <button onClick={ handleClick } >Submit</button>
        </form>
      ))} 
    </div>
  )
}

export default UpdateClub;
