import Login from './pages/Login';
import SignUp from './pages/SignUp'
import Home from './pages/Home'
import AddPersonnel from './pages/AddPersonnel'
import UpdatePersonnel from './pages/UpdatePersonnel'
import ChangeLinks from './pages/ChangeLinks'
import { Routes, Route } from 'react-router-dom';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="register" element={<SignUp />} />
      <Route path="login" element={<Login />} />
      <Route path="add" element={<AddPersonnel />} />
      <Route path="update" element={<UpdatePersonnel />} />
      <Route path="clubs" element={<Login />} />
      <Route path="links" element={<ChangeLinks />} />
    </Routes>
  );
}

export default App;
