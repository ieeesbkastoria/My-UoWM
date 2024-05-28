import { useNavigate, Link } from  "react-router-dom";
import { useContext } from  "react"
import AuthContext from "../components/AuthProvider";
import Nav from "../components/Nav";

const Home = () => {
  const { setAuth } = useContext(AuthContext);
  const navigate = useNavigate();

  const logout = async () => {
    setAuth({});
    navigate('/login');
  }

  return (
  <>
    <Nav />
    <div className="my-1 flex justify-center items-center h-screen">
      <div className="bg-slate-800 p-8 rounded shadow border border-gray-200 max-w-md">
          <p className="text-gray-50">The user-friendly CMS Edit Suite empowers authorized university personnel to manage key website aspects. Effortlessly update hyperlinks, maintain a dynamic cafeteria meal plan, and keep faculty and staff profiles current – all through an intuitive interface, improving website accuracy, user experience, and communication efficiency.</p>
      </div>
    </div>
  </>
);

}


export default Home;
