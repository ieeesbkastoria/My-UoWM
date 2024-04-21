
import {useState} from "react";

const AddClub = () => {
  const [name, setName] = useState('');
  const [link, setLink] = useState('');
  const [isPending, setIsPending] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    const club = {name, link};

    setIsPending(true);

    fetch('http://localhost:8080/admin/clubs', {
      method: 'POST',
      header: {"Content-Type": "application/json",},
      body: JSON.stringify(club),
    })
      .then(() => {
        console.log("new club added");
        setIsPending(false);
      })
      .catch((e) => {
        console.log(JSON.stringify(club));
        console.log("Couldn't add club" + e);
      })
  }

  return (
    <div className="add_club">
      <h1>Add a Club</h1>
      <form onSubmit={handleSubmit}>
        <label>Club name:</label>
          <input
              type = "text"
              required
              value = {name}
              onChange = {(e) => setName(e.target.value)}
          />
        <label>Club link:</label>
          <input
              type = "text"
              required
              value = {link}
              onChange = {(e) => setName(e.target.value)}
          />
        <button> Submit </button>
      </form>
  </div>
  );
}

export default AddClub;
