import {useState } from "react";
import useAxiosPrivate from '../hooks/useAxiosPrivate';

const PERSONNEL_URL = '/api/admin/personnel'

const AddPersonnel = () => { 

  const axiosPrivate = useAxiosPrivate();

  // TODO these need to be updated according to the project requirements
  const [id, setId] = useState('');
  const [name, setName] = useState('');
  const [office, setOffice] = useState('');
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [department, setDepartment] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axiosPrivate.post(PERSONNEL_URL,
      JSON.stringify({ id, name, office, email, phone, department }));
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
  return(
  <div className="add-personnel bg-gray-100 p-8 rounded-lg shadow-md">
  <h1 className="text-2xl font-bold text-blue-700 mb-6">Add Personnel</h1>
  <form onSubmit={handleSubmit}>
    <div className="mb-4">
      <label className="block text-gray-700 mb-2">Personnel Id:</label>
      <input
        type="text"
        required
        value={id}
        onChange={(e) => setId(e.target.value)}
        className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
      />
    </div>
    <div className="mb-4">
      <label className="block text-gray-700 mb-2">Personnel name:</label>
      <input
        type="text"
        required
        value={name}
        onChange={(e) => setName(e.target.value)}
        className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
      />
    </div>
    <div className="mb-4">
      <label className="block text-gray-700 mb-2">Personnel department:</label>
      <input
        type="text"
        required
        value={department}
        onChange={(e) => setDepartment(e.target.value)}
        className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
      />
    </div>
    <div className="mb-4">
      <label className="block text-gray-700 mb-2">Personnel OfficeNumber:</label>
      <input
        type="text"
        required
        value={office}
        onChange={(e) => setOffice(e.target.value)}
        className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
      />
    </div>
    <div className="mb-4">
      <label className="block text-gray-700 mb-2">Personnel Phone number:</label>
      <input
        type="text"
        required
        value={phone}
        onChange={(e) => setPhone(e.target.value)}
        className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
      />
    </div>
    <div className="mb-4">
      <label className="block text-gray-700 mb-2">Personnel email:</label>
      <input
        type="text"
        required
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
      />
    </div>
    <button
      type="submit"
      className="w-full bg-yellow-500 text-white p-2 rounded hover:bg-yellow-600 focus:outline-none focus:ring-2 focus:ring-yellow-400"
    >
      Submit
    </button>
  </form>
</div>
  );
}

export default AddPersonnel;
