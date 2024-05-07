import { useState } from 'react'

const WeekTable = () => {
  const [open, setOpen] = useState(false);

  const handleOpen = () => {
    setOpen(!open);
  };

  return (
    <div classNane="week-table">
      <button onClick={ handleOpen }>Edit</button>
      { open ? <div>Is Open</div> : <div></div>}
    </div>
  );
};

export default WeekTable;
