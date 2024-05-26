import {useState, useEffect } from "react";
import useAxiosPrivate from '../hooks/useAxiosPrivate';

const POST_PERSONNEL_URL = '/api/admin/personnel';
const GET_PERSONNEL_URL = '/api/myuowm/personnel';

const UpdatePersonnel = () => {

  const [personnel, setPersonnel] = useState();
  //Might need diffrent Axios(not private)
  const axiosPrivate = useAxiosPrivate();

  useEffect(() => {
    let isMounted = true;
    const controller = new AbortController();

    const getPersonnel = async () => {
      try {
        const response = await axiosPrivate.get(GET_PERSONNEL_URL, {
          signal: controller.signal
        });
        console.log(response.data);
        isMounted && setPersonnel(response.data);
      } catch (err) {
        console.error(err);
        //TODO Redirect user to login if not loged in if Unauthorized
      }
    }
    
    getPersonnel();

    return () => {
      isMounted = false;
      controller.abort();
    }
  }, [])

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axiosPrivate.post(POST_PERSONNEL_URL,
      JSON.stringify(personnel));
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

  //TODO Impement put request of personnel data
  return (
    <div className="update-personnel bg-gray-100 p-8 rounded-lg shadow-md">
  <article>
    <ul>
      {personnel?.map((employee, index) => (
        <li key={index} className="mb-6">
          <form onSubmit={handleSubmit} className="bg-white p-6 rounded-lg shadow-sm">
            <div className="mb-4">
              <label className="block text-gray-700 mb-2">Personnel name:</label>
              <input
                type="text"
                required
                value={employee.name}
                onChange={(e) => {
                  const updatedEmployee = { ...employee, name: e.target.value };
                  setPersonnel([...personnel.slice(0, index), updatedEmployee, ...personnel.slice(index + 1)]);
                }}
                className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
              />
            </div>
            <div className="mb-4">
              <label className="block text-gray-700 mb-2">Personnel department:</label>
              <input
                type="text"
                required
                value={employee.department}
                onChange={(e) => {
                  const updatedEmployee = { ...employee, department: e.target.value };
                  setPersonnel([...personnel.slice(0, index), updatedEmployee, ...personnel.slice(index + 1)]);
                }}
                className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
              />
            </div>
            <div className="mb-4">
              <label className="block text-gray-700 mb-2">Personnel OfficeNumber:</label>
              <input
                type="text"
                required
                value={employee.officeNumber}
                onChange={(e) => {
                  const updatedEmployee = { ...employee, officeNumber: e.target.value };
                  setPersonnel([...personnel.slice(0, index), updatedEmployee, ...personnel.slice(index + 1)]);
                }}
                className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
              />
            </div>
            <div className="mb-4">
              <label className="block text-gray-700 mb-2">Personnel Phone number:</label>
              <input
                type="text"
                required
                value={employee.phone}
                onChange={(e) => {
                  const updatedEmployee = { ...employee, phone: e.target.value };
                  setPersonnel([...personnel.slice(0, index), updatedEmployee, ...personnel.slice(index + 1)]);
                }}
                className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
              />
            </div>
            <div className="mb-4">
              <label className="block text-gray-700 mb-2">Personnel email:</label>
              <input
                type="email"
                required
                value={employee.email}
                onChange={(e) => {
                  const updatedEmployee = { ...employee, email: e.target.value };
                  setPersonnel([...personnel.slice(0, index), updatedEmployee, ...personnel.slice(index + 1)]);
                }}
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
        </li>
      ))}
    </ul>
  </article>
</div>
  );
}

export default UpdatePersonnel
