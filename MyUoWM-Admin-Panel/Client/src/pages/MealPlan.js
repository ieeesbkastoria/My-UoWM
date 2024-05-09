import WeekTable from '../components/WeekTable';
import { useState } from "react";
import useAxiosPrivate from '../hooks/useAxiosPrivate';

const GET_MEAL_URL = '/api/myuowm/lesxi';
const POST_MEAL_URL = '/api/admin/lesxi';

const MealPlan = () => {

  const [meals, setMeals] = useState();

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
        isMounted && setMeals(response.data);
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
      JSON.stringify(meals));
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
