
import React from "react";
import { useAuth0 ,withAuthenticationRequired } from "@auth0/auth0-react";
import Loading from "./Loading";

const Profile = () => {
  const { user, isAuthenticated, isLoading } = useAuth0();

  if (isLoading) {
    return <div>Loading ...</div>;
  }

  return (
    isAuthenticated && (
      <div className="user-profile">
        <div className="card">
          <img className="profile-pic" src={user.picture} alt={user.name} />
          <h2 className="name">{user.name}</h2>
          <p className="email">{user.email}</p>
          <br/>
          {Object.entries(user).map(([key, value]) => (
            <p key={key}>{`${key}: ${value}`}</p>
          ))}
        </div>
      </div>
    )
  );
};

// Allow profile to be accessed only by authenticated users
export default withAuthenticationRequired(Profile, {
    onRedirecting: () => <Loading />,
  });
