import { useState, useEffect } from "react";
import axios from '../api/axios'

const Users = () => {
  const [users, setUsers] = useState();

  userEffect(() => {
    let isMounted = true;
    const controller = new AbortController();

    const getUsers = async () => {
      try {
        const response = await axios.get('/users', {
          singnal: controller.signal
        });
        console.log(response.data);
      } catch (err) {
        console.error(err);
      }
    }

    getUsers();

    return () => {
      isMounted = false;
      controller.abort();
    }
  }, [])

  return (
    <article>
      <h2>Users List</h2>
      {users?.length
        ? (
            <ul>
              {users.map((user, i) => 
                <li key={i}>{user?.
                username}</li>)}
            </ul>
        ) : <p>No users to display</p>
      }
    </article>
  )
}

export default Users;
