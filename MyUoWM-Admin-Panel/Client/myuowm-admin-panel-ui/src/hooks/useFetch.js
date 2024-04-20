const { useEffect } = require("react");

const useFetch = (url) => {
  const [data, setData] = useState(null);
  const [isPending, setIsPending] = useState(true);
  const [error, setError] = usState(null);

  useEffect(() => {
    const aboardCont = new AbortController();
    fetch(url)
      .then(response => {
        if(!response.ok) { //error from server
          throw Error('Could not fetch the data for that resource')
        }
        return response.json();
      })
      .then(data => {
        setIsPending(false);
        setData(data);
        setError(null);
      })
      .catch(err => {
        if(err.name === "AbortError") {
          console.log("fetch error");
        } else {
          // auto catches network and connection errors
          setIsPending(false);
          setError(err.message );
        }
      })
    return () => aboardCont.abort();
  }, [url])

  return {data, isPending, error};
}

export default useFetch;
