
//redirected here after auth0 login
//query if user is in the database
//if yes, set cookie to true
//if no, set cookie to false
//redirect to home page

import Loading from "./Loading";
import { useAuth0,withAuthenticationRequired } from "@auth0/auth0-react";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Cookies from "js-cookie";
import useBlogs from "./Services/useBlogs";

const Authorize = () => {
    const { user, isAuthenticated, isLoading, logout, getAccessTokenSilently } = useAuth0();
    const navigate = useNavigate();

    const getToken = async () => {
        try {
            const token = await getAccessTokenSilently();
            console.log("TOKEN", token);
        } catch (e) {
            console.log(e.message);
        }
    };

    useEffect(() => {
        if (!isAuthenticated) {
            return;
        }
        const checkUser = async () => {
            // const response = await fetch(`http://localhost:8000/auth/users/${user.email}`);
            //set response to true for now
            const response = { status: 500 };
            if (response.status === 200) {
                Cookies.set("isAllowed", "true");
            } else {
                Cookies.set("isAllowed", "false");
            }
            navigate("/");
        };
        checkUser();
    }
    );

    return (
        <div>
            <Loading />
        </div>
    );
};

export default withAuthenticationRequired(Authorize, {
    onRedirecting: () => <Loading />,
  });
  