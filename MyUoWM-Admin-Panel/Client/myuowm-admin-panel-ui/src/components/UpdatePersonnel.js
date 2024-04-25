import useFetch from '../hooks/useFetch';

const UpdatePersonnel = () => {
  const [personnel, error, isPending] = useFetch('http//localhost:8080/myuowm/personnel');

  const handleClick = (personnel) => {
    // Implement logic to submit updated employee data to server
    // This might involve using the fetch API or a library like Axios
    console.log('Submitting updated data for:', personnel); // Placeholder for now
  };

  return (
    <div className="personnel-update">
      {isPending && <div>Loading...</div>}
      {error && <div>{error}</div>}
      {personnel && (
        <ul>
          {personnel.map((employee) => (
            <li key={employee.id}> 
            <form>
                <label>Name</label>
                <input
                  type="text"
                  value={employee.name}
                  required
                  onChange={(e) => (employee.name = e.target.value)}
                />
                <label>Department</label>
                <input
                  type="text"
                  value={employee.department}
                  required
                  onChange={(e) => (employee.name = e.target.value)} // Typo fixed
                />
                <label>Email</label>
                <input
                  type="email"
                  value={employee.email}
                  required
                  onChange={(e) => (employee.email = e.target.value)}
                />
                <button onClick={() => handleClick(personnel)}>Submit</button>
              </form>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default UpdatePersonnel;

