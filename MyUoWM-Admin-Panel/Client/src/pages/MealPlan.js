import WeekTable from '../components/WeekTable';
import { useState } from "react";
const MealPlan = () => {

  const [meals, setMeals] = useState();

  const handleDataFromChild = (data) => {
    setMeals(data); //TODO only update specific week not whole Meals
  };

  return (
    <div ClassName="meal-plan">
      <h1>Create/Update meal plan</h1>
    
      <h2>Week 1</h2>
      <WeekTable 
        sendDataToParent={ handleDataFromChild }
        parentData= { meals /* TODO only send specific week */}/>
      <h2>Week 2</h2>
      <WeekTable 
        sendDataToParent={ handleDataFromChild }
        parentData= { meals /* TODO only send specific week */}/>
      <h2>Week 3</h2>
      <WeekTable 
        sendDataToParent={ handleDataFromChild }
        parentData= { meals /* TODO only send specific week */}/>
      <h2>Week 4</h2>
      <WeekTable 
        sendDataToParent={ handleDataFromChild }
        parentData= { meals /* TODO only send specific week */}/>
    </div>
  )
};

export default MealPlan;
