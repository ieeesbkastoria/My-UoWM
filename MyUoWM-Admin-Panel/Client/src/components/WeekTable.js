import { useState } from 'react'

const WeekTable = (sendDataToParent, parentData) => {
  const [open, setOpen] = useState(false);
  const [week, setWeek] = useState(parentData);

  const handleOpen = () => {
    setOpen(!open);
  };

  const onSubmit = () => {
    sendDataToParent(week);
  };

  return (
    <div classNane="week-table">
      <button onClick={ handleOpen }>Edit</button>
      { open ? <div>Is Open</div> : <div></div>}
    </div>
  );
};

export default WeekTable;
