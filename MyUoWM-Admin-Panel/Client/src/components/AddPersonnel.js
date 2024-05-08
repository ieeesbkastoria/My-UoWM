import {useState, useEffect } from "react";
import useAxiosPrivate from "../hooks/useAxiosPrivate";
import UseAxiosPrivate from '../hooks/useAxiosPrivate';

const AddPersonnel = () => { 

  const [personnel, setPersonnel] = useState();
  const axiosPrivate = useAxiosPrivate();

  useEffect(() => {
    let isMounted = true;
    const controller = new AbortController();

    const getPersonnel = async () => {
      try {
        const response = await axiosPrivate.get('/personnel', {
          signal: controller.signal
        });
        console.log(response.data);
        isMounted && setPersonnel(response.data);
      } catch (err) {
        console.error(err);
        //TODO Redirect user to login if not loged in
      }
    }
    
    getUsers();
    return () => {
      isMounted = false;
      controller.abort();
    }
  }, [])

  //Out of date method
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
