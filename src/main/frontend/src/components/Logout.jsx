// LogoutButton.jsx
import { useAuth0 } from "@auth0/auth0-react";
import Cookies from 'js-cookie';
import { Link } from "react-router-dom";

const Logout = () => {
  const { logout } = useAuth0();

  const logoutWithRedirect = () => {
    //remove cookie
    Cookies.remove("isAllowed");
    logout({
      logoutParams: {
        returnTo: window.location.origin,
      },
    });
  };

  return <Link onClick={logoutWithRedirect}>Logout</Link>;
};

export default Logout;