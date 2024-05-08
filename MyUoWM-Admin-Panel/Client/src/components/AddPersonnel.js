import {useState } from "react";
import useAxiosPrivate from "../hooks/useAxiosPrivate";

const PERSONNEL_URL = '/api/admin/personnel'

const AddPersonnel = () => { 

  const axiosPrivate = useAxiosPrivate();

  // TODO these need to be updated according to the project requirements
  const [name, setName] = useState('');
  const [office, setOffice] = useState('');
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [department, setDepartment] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axiosPrivate.post(PERSONNEL_URL,
      JSON.stringify({ name, office, email, phone, department }));
      console.log(JSON.stringify(response?.data));
    } catch (err) {
      if (!err?.response) {
        console.log('No Server Response');
      } else if (err.response?.status === 400) {
        console.log('Missing element');
      } else if (err.response?.status === 401) {
        //TODO Redirect to login
        console.log('Unauthorized');
      } else {
        console.log('Post Failed');
      }
    }
  }

  //TODO Update form according to project requirements
  return (
    <div className="add-personnel">
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
          <button onSubmit={ handleSubmit } > Submit </button>
        </form>
    </div>
  );
}

export default AddPersonnel;
