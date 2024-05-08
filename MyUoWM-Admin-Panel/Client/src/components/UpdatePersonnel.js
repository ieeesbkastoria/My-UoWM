import {useState, useEffect } from "react";
import { useAxiosPrivate } from '../hooks/useAxiosPrivate';

const UpdatePersonnel = () => {

  const [personnel, setPersonnel] = useState();
  const axiosPrivate = useAxiosPrivate();

  useEffect(() => {
    let isMounted = true;
    const controller = new AbortController();

    const getPersonnel = async () => {
      try {
        const response = await axiosPrivate.get('api/myuowm/personnel', {
          signal: controller.signal
        });
        console.log(response.data);
        isMounted && setPersonnel(response.data);
      } catch (err) {
        console.error(err);
        //TODO Redirect user to login if not loged in
      }
    }
    
    getPersonnel();
    return () => {
      isMounted = false;
      controller.abort();
    }
  }, [])

  //TODO Impement put request of personnel data
  return (
    <div className="update-personnel">
      <article>
        <ul>
          { personnel.map((employee) => {
            <li>{employee?.name }</li>
          })}
        </ul>
      </article>
    </div>
  );
}

export default UpdatePersonnel
