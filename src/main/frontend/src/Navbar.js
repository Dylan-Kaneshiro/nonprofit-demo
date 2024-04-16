import {Link} from 'react-router-dom';
import Cookies from 'js-cookie';

const Navbar = () => {
    //check if user is logged in by checking if there is a token in cookies
    const isLoggedIn = Cookies.get('isLoggedIn') === 'true';

    return ( 
        <nav className="navbar">
            <h1>The Giving Tree</h1>
            <div className="links">
                <Link to="/">Home</Link>
                {isLoggedIn && <Link to="/create">Create New Post</Link>}
                {!isLoggedIn && <Link to="/login">Login</Link>}
            </div>
        </nav>
     );
}
 
export default Navbar;