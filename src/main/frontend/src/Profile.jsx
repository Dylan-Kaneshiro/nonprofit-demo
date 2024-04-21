import React from "react";
import { useAuth0, withAuthenticationRequired } from "@auth0/auth0-react";
import Loading from "./Loading";
import useFetch from "./useFetch";
import BlogList from "./BlogList";

const Profile = () => {
  const { user, isAuthenticated, isLoading } = useAuth0();
  const {
    error,
    isPending,
    data: blogs,
  } = useFetch("http://localhost:8086/blogs/email=" + user.email);
  console.log("RETURNING BLOG DATA FROM COMPONENT", blogs);

  if (isLoading) {
    return <div>Loading ...</div>;
  }

  //Check if user is part of the database

  return (
    isAuthenticated && (
      <div className="user-profile">
        <div className="card">
          <img className="profile-pic" src={user.picture} alt={user.name} />
          <h2 className="name">{user.name}</h2>
          <p className="email">{user.email}</p>
          <br />
          {Object.entries(user).map(([key, value]) => (
            <p key={key}>{`${key}: ${value}`}</p>
          ))}
        </div>
        <div>
          {/* <h2>My Blogs</h2> */}
          {/* <button onClick={getUserPosts}>Get My Blogs</button> */}
          { blogs ? (<BlogList blogs={blogs} title="History" />):(<div>Null...</div>)}
        </div>
      </div>
    )
  );
};

// Allow profile to be accessed only by authenticated users
export default withAuthenticationRequired(Profile, {
  onRedirecting: () => <Loading />,
});