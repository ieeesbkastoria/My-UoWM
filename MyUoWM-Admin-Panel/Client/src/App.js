import Login from './pages/Login';
import SignUp from './pages/SignUp'
import Home from './pages/Home'
import Personnel from './pages/Personnel'
import MealPlan from './pages/MealPlan'
import ChangeLinks from './pages/ChangeLinks'
import { Routes, Route } from 'react-router-dom';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="register" element={<SignUp />} />
      <Route path="login" element={<Login />} />
      <Route path="personnel" element={<Personnel />} />
      <Route path="clubs" element={<Login />} />
      <Route path="meals" element={<MealPlan />} />
      <Route path="links" element={<ChangeLinks />} />
    </Routes>
  );
}

export default App;
