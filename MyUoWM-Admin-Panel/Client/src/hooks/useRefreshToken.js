import axios from '../api.axios';
import useAuth from './useAuth';

const useRefreshToken = () => {
  const { setAuth } = useAuth();

  const refresh = async () => {
    const respone = await axios.get('api/auth/refresh-token', {
      withCredentials: true,
    });

    setAuth(prev => {
      constole.log(JSON.stringify(prev));
      constole.log(JSON.stringify(respone));
      
      return {... prev, accessToken: respone.data.accessToken };
    });

    return respone.data.accessToken;
  }

  return refresh;
};

export default useRefreshToken;
