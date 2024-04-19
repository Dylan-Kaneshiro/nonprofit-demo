import BlogList from "./BlogList";
import useFetch from "./useFetch";
import { useState } from "react";
import useBlogs from "./Services/useBlogs";
// import Cookies from 'js-cookie';

const Home = () => {
  const [tempSearchTerm, setTempSearchTerm] = useState("");
  const [searchTerm, setSearchTerm] = useState("");
  // Directly use `useBlogs` with the searchTerm, initiating it with an empty string or a default value.
  const { error, isPending, data: blogs } = useBlogs(searchTerm);

  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent form submission from reloading the page
    // No need to manually fetch or set state here; `useBlogs` handles it based on `searchTerm`.
    setSearchTerm(tempSearchTerm);
  };

  return (
    <div className="home">
      <img src="/images/breadfruit.png" alt="" />

      {/*Search Bar */}
      <form onSubmit={handleSubmit} class="search-bar-wrapper">
        <input
          class="search"
          type="text"
          placeholder="Search for posts..."
          value={tempSearchTerm}
          onChange={(e) => setTempSearchTerm(e.target.value)}
        />
      </form>

      {error && <div>{error}</div>}
      {isPending && <div>Loading...</div>}
      {blogs && <BlogList blogs={blogs} title="Popular" />}

    </div>
  );
};

export default Home;
