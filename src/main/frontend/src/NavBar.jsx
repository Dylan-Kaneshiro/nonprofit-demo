import { Link } from "react-router-dom";
import { useAuth0 } from "@auth0/auth0-react";
import {useAllowed} from './util/useAllowed';
import Login from './components/Login';
import Logout from './components/Logout';

const NavBar = () => {

  const { user, isAuthenticated, loginWithRedirect, logout } = useAuth0();

  const {isAllowed} = useAllowed();

  return (
    <nav className="navbar">
      <img src="images/logo.jpg"></img>
      <h1>The Giving Tree</h1>

      <div className="links">
        <ul>
          <Link to="/">Home</Link>

          {isAuthenticated ? (
            <>
              {isAllowed ? <Link to="/create">Create New Blog</Link> : <></>}
              <Link to="/profile">Profile</Link>
              <Logout />
              <img src={user.picture} />
            </>
          ) : (
            <Login />
          )}
        </ul>
      </div>
    </nav>
  );
};

export default NavBar;
