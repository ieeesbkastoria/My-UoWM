import {useState} from "react";

const AddPersonnel = () => { 
  const [name, setName] = useState('');
  const [department, setDepartment]= useState('');
  const [officeHours, setOfficeHours] = useState('');
  const [office, setOffice] = useState('');
  const [phone, setPhone] = useState('');
  const [email, setEmail] = useState('');
  const [personnel_id, setId] = useState('22');
  const [isPending, setIsPendign] = useState(false);


  const handleSubmit = (e) => {
    e.preventDefault();
    const personnel = {personnel_id, department, name, phone, office, officeHours, email};

    setIsPendign(true);

    fetch('http://localhost:8080/admin/personnel', {
      method: 'POST',
      headers: {"Content-Type": "application/json",},
      body: JSON.stringify(personnel),
    })
      .then(() => {
        console.log("new personnel added");
        setIsPendign(false);
      })
      .catch((e) => {
        console.log(JSON.stringify(personnel));
        console.log("Couldn't add personnel" + e.message);
      })
  }

  return (
    <div className="add_personnel">
      <h1>Add Personnel</h1>
        <form onSubmit={handleSubmit}>
          <label>Personnel name:</label>
            <input
                type="text"
                required
                value={name}
                onChange={(e) => setName(e.target.value)}
            />
          <label>Personnel department:</label>
            <input
                type="text"
                required
                value={department}
                onChange={(e) => setDepartment(e.target.value)}
            />
          <label>Personnel OfficeHours:</label>
            <input
                type="text"
                required
                value={officeHours}
                onChange={(e) => setOfficeHours(e.target.value)}
            />
          <label>Personnel OfficeNumber:</label>
            <input
                type="text"
                required
                value={office}
                onChange={(e) => setOffice(e.target.value)}
            />
          <label>Personnel Phone number:</label>
            <input
                type="text"
                required
                value={phone}
                onChange={(e) => setPhone(e.target.value)}
            />
          <label>Personnel email:</label>
            <input
                type="text"
                required
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />
          <button> Submit </button>
        </form>
    </div>
  );
}

export default AddPersonnel;
