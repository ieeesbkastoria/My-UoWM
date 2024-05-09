import { useState } from "react";
import useAxiosPrivate from '../hooks/useAxiosPrivate';

const ChangeLinks = () => {
  const [links, setLinks] = useState

  const axiosPrivate = useAxiosPrivate();

  useEffect(() => {
    let isMounted = true;
    const controller = new AbortController();

    const getLinks = async () => {
      try {
        const response = await axiosPrivate.get(GET_PERSONNEL_URL, {
          signal: controller.signal
        });
        console.log(response.data);
        isMounted && setLinks(response.data);
      } catch (err) {
        console.error(err);
        //TODO Redirect user to login if not loged in if Unauthorized
      }
    }
    
    getLinks();
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

  return (
    <div className="change-links">
      <article>
        <form onSubmit={handleSubmit}>
          { links.map((link, index) => {
            <div>
            <label>Change { link.usage }</label>
              <input
                  type="url"
                  required
                  value={ link.url }
                  onChange={(e) => {
                    link.usage = e.target.value;
                    setLinks(links.splice(index, link));
              }}
              />
            </div>
            })}
            <button onSubmit={ handleSubmit } > Submit </button>
          </form>
      </article>
    </div>
  )
};

export default ChangeLinks;
