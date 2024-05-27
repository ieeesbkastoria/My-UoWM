import { useState, useEffect } from "react";
import useAxiosPrivate from '../hooks/useAxiosPrivate';

const GET_MEAL_URL = '/api/myuowm/lesxi';
const POST_MEAL_URL = '/api/admin/lesxi';

const MealPlan = () => {

  const [plan, setPlan] = useState();

  const axiosPrivate = useAxiosPrivate();

  //fetch links from server
  useEffect(() => {
    let isMounted = true;
    const controller = new AbortController();

    const getMeals = async () => {
      try {
        const response = await axiosPrivate.get(GET_MEAL_URL, {
          signal: controller.signal
        });
        console.log(response.data);
        isMounted && setPlan(response.data);
      } catch (err) {
        console.error(err);
        //TODO Redirect user to login if not loged in if Unauthorized
      }
    }
    
    getMeals();
    return () => {
      isMounted = false;
      controller.abort();
    }
  }, [])

  //send meal plan information to server after form submit
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axiosPrivate.post(POST_MEAL_URL,
      JSON.stringify(plan));
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

  const handleEdit = (week, day, meal, field, value) => {
    const updatedPlan = [...plan];
    updatedPlan[week - 1].days[day - 1].meals[meal - 1][field] = value;
    setPlan(updatedPlan);
  };

  const renderWeek = (week) => {
  const days = plan[week - 1].days;
  return (
    <div key={week} className="mb-6 p-4 bg-gray-100 rounded shadow">
      <h2 className="text-xl font-bold text-blue-500 mb-2">Week {week}</h2>
      {days.map((day, index) => (
        <div key={index} className="mb-4">
          <h3 className="text-lg font-semibold text-red-500 mb-2">{day.name}</h3>
          {renderDay(day)}
        </div>
      ))}
    </div>
  );
};

const renderDay = (day) => {
  const meals = day.meals;
  return (
    <div className="ml-4">
      {meals.map((meal, index) => (
        <div key={index} className="mb-4">
          <h4 className="text-md font-semibold text-yellow-500 mb-2">{meal.type}</h4>
          <ul className="list-disc list-inside">
            <li className="mb-2">
              <label className="block mb-1 text-gray-700">Main Dish 1:</label>
              <input
                className="w-full p-2 border border-gray-300 rounded"
                type="text"
                value={meal.mainDish1}
                onChange={(e) =>
                  handleEdit(day.week, day.index + 1, index + 1, 'mainDish1', e.target.value)
                }
              />
            </li>
            <li className="mb-2">
              <label className="block mb-1 text-gray-700">Main Dish 2:</label>
              <input
                className="w-full p-2 border border-gray-300 rounded"
                type="text"
                value={meal.mainDish2}
                onChange={(e) =>
                  handleEdit(day.week, day.index + 1, index + 1, 'mainDish2', e.target.value)
                }
              />
            </li>
            <li className="mb-2">
              <label className="block mb-1 text-gray-700">Salad:</label>
              <input
                className="w-full p-2 border border-gray-300 rounded"
                type="text"
                value={meal.salad}
                onChange={(e) =>
                  handleEdit(day.week, day.index + 1, index + 1, 'salad', e.target.value)
                }
              />
            </li>
            <li className="mb-2">
              <label className="block mb-1 text-gray-700">Dessert:</label>
              <input
                className="w-full p-2 border border-gray-300 rounded"
                type="text"
                value={meal.dessert}
                onChange={(e) =>
                  handleEdit(day.week, day.index + 1, index + 1, 'dessert', e.target.value)
                }
              />
            </li>
          </ul>
        </div>
      ))}
    </div>
  );
};

return (
  <div className="meal-plan p-6 bg-gray-50">
    <h1 className="text-2xl font-bold text-blue-700 mb-6">Meal Plan</h1>
    {plan.map((week) => renderWeek(week.week))}
  </div>
);
}

export default MealPlan;
