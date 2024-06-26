import React from "react";
import { useAuth0, withAuthenticationRequired } from "@auth0/auth0-react";
import Loading from "./Loading";
import useFetch from "./useFetch";
import MyBlogList from "./MyBlogList";
import useMyBlogs from "./Services/useMyBlogs";

import { useAllowed } from "./util/useAllowed";

const Profile = () => {
  const { user, isAuthenticated, isLoading } = useAuth0();
  const {isAllowed} = useAllowed();
  // const {
  //   error,
  //   isPending,
  //   data: blogs,
  // } = useFetch("http://localhost:8086/blogs/email=" + user.email);
  // console.log("RETURNING BLOG DATA FROM COMPONENT", blogs);

  const { error, isPending, data: blogs } = useMyBlogs(user.email);

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
          {isAllowed ? (
            <div>
              {blogs ? (
                <MyBlogList blogs={blogs} />
              ) : (
                <div>Null...</div>
              )}
            </div>
          ) : (
            <div>
              <h2>Unauthorized</h2>
              <p>
                You are not authorized to view this page. Please contact the
                administrator.
                contact to register as an organization
              </p>
              

            </div>
          )}
        </div>
      </div>
    )
  );
};

// Allow profile to be accessed only by authenticated users
export default withAuthenticationRequired(Profile, {
  onRedirecting: () => <Loading />,
});
