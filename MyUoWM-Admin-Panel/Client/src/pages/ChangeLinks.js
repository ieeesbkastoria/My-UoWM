import { useState, useEffect } from "react";
import useAxiosPrivate from '../hooks/useAxiosPrivate';

const GET_LINKS_URL = '/api/myuowm/links';
const POST_LINKS_URL = '/api/admin/links';
const ChangeLinks = () => {
  const [links, setLinks] = useState();

  const axiosPrivate = useAxiosPrivate();

  //fetch links from server
  useEffect(() => {
    let isMounted = true;
    const controller = new AbortController();

    const getLinks = async () => {
      try {
        const response = await axiosPrivate.get(GET_LINKS_URL, {
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
      controller.abort(); }
  }, [])

  //send link information to server after form submit
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axiosPrivate.post(POST_LINKS_URL,
      JSON.stringify(links));
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
    <div className="change-links bg-gray-100 p-8 rounded-lg shadow-md">
  <article>
    <form onSubmit={handleSubmit} className="space-y-4">
      {links?.map((link, index) => (
        <div key={index} className="bg-white p-4 rounded shadow-sm">
          <label className="block text-gray-700 mb-2">
            Change {link.usage}
          </label>
          <input
            type="url"
            required
            value={link.url}
            onChange={(e) => {
              const updatedLink = { ...link, url: e.target.value };
              setLinks([...links.slice(0, index), updatedLink, ...links.slice(index + 1)]);
            }}
            className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>
      ))}
      <button
        type="submit"
        className="w-full bg-yellow-500 text-white p-2 rounded hover:bg-yellow-600 focus:outline-none focus:ring-2 focus:ring-yellow-400"
      >
        Submit
      </button>
    </form>
  </article>
</div>

  )
};

export default ChangeLinks;
