import React from "react";
import { useAuth0, withAuthenticationRequired } from "@auth0/auth0-react";
import Loading from "./Loading";
import useFetch from "./useFetch";
import BlogList from "./BlogList";
import { useCookie } from "react-use";

const Profile = () => {
  const { user, isAuthenticated, isLoading } = useAuth0();
  const [cookie] = useCookie("isAllowed");
  const [isAllowed, setIsAllowed] = useState(false);

  const {
    error,
    isPending,
    data: blogs,
  } = useFetch("http://localhost:8086/blogs/email=" + user.email);
  console.log("RETURNING BLOG DATA FROM COMPONENT", blogs);

  // if (isLoading) {
  //   return <div>Loading ...</div>;
  // }
  useEffect(() => {
    if (cookie === "true") {
      setIsAllowed(true);
    } else {
      setIsAllowed(false);
    }
  }, [cookie]);

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
                <BlogList blogs={blogs} title="History" />
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
