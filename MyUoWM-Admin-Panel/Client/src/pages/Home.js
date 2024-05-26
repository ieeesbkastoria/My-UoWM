import { useNavigate, Link } from  "react-router-dom";
import { useContext } from  "react"
import AuthContext from "../components/AuthProvider";

const Home = () => {
  const { setAuth } = useContext(AuthContext);
  const navigate = useNavigate();

  const logout = async () => {
    setAuth({});
    navigate('/login');
  }

  return (
    <section>
      <div className="font-bold underline">
        <h1>Home</h1>
        <br />
        <Link to="/personnel">Edit Personnel</Link>
        <Link to="/clubs">Edit clubs</Link>
        <Link to="/meals">Edit meal plan</Link>
        <Link to="/links">Edit change hyper-links</Link>
      </div>
    </section>
  )
}

export default Home;
