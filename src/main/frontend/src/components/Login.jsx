// LoginButton.jsx
import { useAuth0 } from "@auth0/auth0-react";
import { Link } from "react-router-dom";

const Login = () => {
  const { loginWithRedirect } = useAuth0();

  const login = async () => {
    await loginWithRedirect({
      appState: { targetUrl: window.location.pathname },
      authorizationParams: {
        prompt: "login",
        redirect_uri: "http://localhost:3000/authorize",
      },
    });
  };

  return <Link onClick={login}>Login</Link>;
};

export default Login;