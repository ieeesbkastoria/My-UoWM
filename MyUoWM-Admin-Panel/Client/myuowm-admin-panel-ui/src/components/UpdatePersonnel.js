import useFetch from '../hooks/useFetch'

const UpdatePersonnel = () => {
  const {personnel, error, isPending} = useFetch('http//localhost:8080/myuowm/personnel');

  const handleClick = () => {}

  return (
    <div className="personnel-update">
      { isPending && <div>Loading...</div> }
      { error && <div>{ error }</div>}
      {personnel && personnel.map(employee => (
        <form>
          <label>Name</label>
            <input type="text" value={ employee.name } required onChange={(e) => employee.name = e.target.value}/>
          <label>Department</label>
            <input type="text" value={ employee.department } required onChange={(e) => employee.department = e.target.value} />
          <label>Email</label>
            <input type="text" value={ employee.officeHours } required onChange={(e) => employee.officeHours = e.target.value}/>
            <input type="text" value={ employee.office } required onChange={(e) => employee.office = e.target.value}/>
            <input type="email" value={ employee.email } required onChange={(e) => employee.email = e.target.value}/>
          <button onClick= {handleClick}> Submit </button>
          <label></label>
            <input type="email" value={ employee.email } required />
          <button onClick= {handleClick}> Submit </button>
        </form>
      ))}
    </div> 
  );
}

export default UpdatePersonnel
