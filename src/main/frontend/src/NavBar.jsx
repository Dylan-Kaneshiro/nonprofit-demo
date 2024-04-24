import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import { useCookie } from 'react-use';

import Cookies from "js-cookie";
import { useAuth0 } from "@auth0/auth0-react";

const NavBar = () => {
  // const [isOpen, setIsOpen] = useState(false);
  const { user, isAuthenticated, loginWithRedirect, logout } = useAuth0();
  //init isAllowed state
  const [cookie, updateCookie, deleteCookie] = useCookie('isAllowed');
  const [isAllowed, setIsAllowed] = useState(false);

  // if cookie changes, set isAllowed to true or false
  useEffect(() => {
    if (cookie === "true") {
      setIsAllowed(true);
    } else {
      setIsAllowed(false);
    }
  }, [cookie]);

  const login = async () => {
    await loginWithRedirect({
      appState: { targetUrl: window.location.pathname },
      authorizationParams: {
        prompt: "login",
        redirect_uri: "http://localhost:3000/authorize",
      },
    });
  };

  const logoutWithRedirect = () => {
    //remove cookie
    Cookies.remove("isAllowed");
    logout({
      logoutParams: {
        returnTo: window.location.origin,
      },
    });
  };

  return (
    <nav className="navbar">
      <img src="images/logo.jpg"></img>
      <h1>The Giving Tree</h1>

      <div className="links">
        <ul>
          <Link to="/">Home</Link>

          {isAuthenticated ? (
            //chect cookie to see if user is in the database
            isAllowed ? (
              <>
                <Link to="/create">New Blog</Link>

                <Link to="/profile">Profile</Link>

                <Link onClick={() => logoutWithRedirect()}>Log out</Link>

                <img src={user.picture} />
              </>
            ) : (
              <>
                <Link to="/profile">Profile</Link>

                <Link onClick={() => logoutWithRedirect()}>Log out</Link>
              </>
            )
          ) : (
            <Link onClick={() => login()}>Log in</Link>
          )}
        </ul>
      </div>
    </nav>
  );
};

export default NavBar;
