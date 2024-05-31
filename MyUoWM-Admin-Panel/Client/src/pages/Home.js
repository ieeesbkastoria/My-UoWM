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
    <div className="my-2 py-1 flex justify-center items-center">
      <div className="space-y-4">
        <div className="bg-slate-800 p-8 rounded shadow-lg border border-gray-700 max-w-md mx-auto">
          <p className="text-gray-50">
            The MyUoWM-Admin-Panel empowers authorized university personnel and authorized students to manage key website aspects. Effortlessly update hyperlinks, maintain a dynamic cafeteria meal plan, and keep faculty and staff profiles current – all through an intuitive interface, improving website accuracy, user experience, and communication efficiency.
          </p>
        </div>
        <div className="flex flex-col items-center space-y-2">
          <img src="https://ieee.cs.uowm.gr/wp-content/uploads/2023/02/logo-ieee.png" className="w-96 h-auto" alt="IEEE Logo"/>
        </div>
      </div>
    </div>
  </>
);


}


export default Home;
