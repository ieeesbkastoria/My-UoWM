import Login from './pages/Login';
import SignUp from './pages/SignUp'
import Home from './pages/Home'
import Personnel from './pages/Personnel'
import { Routes, Route } from 'react-router-dom';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="register" element={<SignUp />} />
      <Route path="login" element={<Login />} />
      <Route path="personnel" element={<Personnel />} />
      <Route path="clubs" element={<Login />} />
    </Routes>
  );
}

export default App;
