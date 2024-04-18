import { Link } from "react-router-dom";
import { useState } from "react";

import Cookies from "js-cookie";
import { useAuth0 } from "@auth0/auth0-react";

const NavBar = () => {
  const [isOpen, setIsOpen] = useState(false);
  const { user, isAuthenticated, loginWithRedirect, logout } = useAuth0();
  // const toggle = () => setIsOpen(!isOpen);

  const logoutWithRedirect = () =>
    logout({
      logoutParams: {
        returnTo: window.location.origin,
      },
    });

  return (
    <nav className="navbar">
      <img src="images/logo.jpg"></img>
      <h1>The Giving Tree</h1>

      <div className="links">
        <ul>
          <Link to="/">Home</Link>

          {isAuthenticated ? (
            <>
              <Link to="/create">New Blog</Link>

              <Link to="/profile">Profile</Link>

              <Link onClick={() => logoutWithRedirect()}>
                Log out
              </Link>

              <img src={user.picture} />
            </>
          ) : (
            <Link onClick={() => loginWithRedirect()}>Log in</Link>
          )}
        </ul>
      </div>
    </nav>
  );
};

export default NavBar;
