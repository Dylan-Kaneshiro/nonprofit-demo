import BlogList from "./BlogList";
import useFetch from "./useFetch";
import { useState } from "react";
import useBlogs from "./Services/useBlogs";
// import { Dropdown}

// import Cookies from 'js-cookie';

const Home = () => {
  const [tempSearchTerm, setTempSearchTerm] = useState("");
  const [searchTerm, setSearchTerm] = useState("");
  const [tempCity, setTempCity] = useState("");
  const [city, setCity] = useState("");

  // Directly use `useBlogs` with the searchTerm, initiating it with an empty string or a default value.
  const { error, isPending, data: blogs } = useBlogs(searchTerm, city);
  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent form submission from reloading the page
    // No need to manually fetch or set state here; `useBlogs` handles it based on `searchTerm`.
    setSearchTerm(tempSearchTerm);
    setCity(tempCity);
  };

  return (
    <div className="home">
      <img src="/images/breadfruit.png" alt="" />

      {/*Search Bar */}
      <form onSubmit={handleSubmit} class="search-bar-wrapper">
        <input
          className="search"
          type="text"
          placeholder="Search posts and organizations"
          value={tempSearchTerm}
          onChange={(e) => setTempSearchTerm(e.target.value)}
        />
        <input
          className="search-city"
          type="text"
          placeholder="City ('Virtual' for online)"
          value={tempCity}
          datalist="cities"
          onChange={(e) => setTempCity(e.target.value)}
        />

        <button class="search-button">Search</button>
      </form>

      {error && <div>{error}</div>}
      {isPending && <div>Loading...</div>}
      {blogs && <BlogList blogs={blogs} title="Popular" />}

    </div>
  );
};

export default Home;
