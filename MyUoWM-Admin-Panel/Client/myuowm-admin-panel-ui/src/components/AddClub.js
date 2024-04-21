
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

  return ();
}

export default AddClub;
