import WeekTable from '../components/WeekTable'

const MealPlan = () => {

  return (
    <div ClassName="meal-plan">
      <h1>Create/Update meal plan</h1>
    
      <h2>Week 1</h2>
      <WeekTable />
      <h2>Week 2</h2>
      <WeekTable />
      <h2>Week 3</h2>
      <WeekTable />
      <h2>Week 4</h2>
    </div>
  )
};

export default MealPlan;
