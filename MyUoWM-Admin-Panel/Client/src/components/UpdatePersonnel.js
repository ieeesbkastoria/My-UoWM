import {useState, useEffect } from "react";
import { useAxiosPrivate } from '../hooks/useAxiosPrivate';

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
    <div className="update-personnel">
      <article>
        <ul>
          { personnel.map((employee, index) => {
            <li>
              <form onSubmit={handleSubmit}>
                <label>Personnel name:</label>
                  <input
                      type="text"
                      required
                      value={ employee.name }
                      onChange={(e) => {
                    employee.department = e.target.value;
                    setPersonnel(personnel.splice(index, employee));
                  }}
                  />
                <label>Personnel department:</label>
                  <input
                      type="text"
                      required
                      value={ employee.department }
                      onChange={(e) => {
                    employee.department = e.target.value;
                    setPersonnel(personnel.splice(index, employee));
                  }}
                  />
                <label>Personnel OfficeNumber:</label>
                  <input
                      type="text"
                      required
                      value={ employee.officeNumber }
                      onChange={(e) => {
                    employee.officeNumber = e.target.value;
                    setPersonnel(personnel.splice(index, employee));
                  }}
                  />
                <label>Personnel Phone number:</label>
                  <input
                      type="text"
                      required
                      value={ employee.phone }
                      onChange={(e) => {
                    employee.phone = e.target.value;
                    setPersonnel(personnel.splice(index, employee));
                  }}
                  />
                <label>Personnel email:</label>
                  <input
                      type="email"
                      required
                      value={ employee.email }
                      onChange={(e) => {
                    employee.email = e.target.value;
                    setPersonnel(personnel.splice(index, employee));
                  }}
                  />
                <button onSubmit={ handleSubmit } > Submit </button>
              </form>
            </li>
          })}
        </ul>
      </article>
    </div>
  );
}

export default UpdatePersonnel
