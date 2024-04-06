import { useState } from "react";
import BlogList from "./BlogList";
import useBlogs from "./Services/useBlogs";

const Home = () => {
  const [searchTerm, setSearchTerm] = useState("");
  // Directly use `useBlogs` with the searchTerm, initiating it with an empty string or a default value.
  const { error, isPending, data: blogs } = useBlogs(searchTerm);

  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent form submission from reloading the page
    // No need to manually fetch or set state here; `useBlogs` handles it based on `searchTerm`.
  };

  return (
    <div className="home">
      <img src="/images/breadfruit.png" alt="" />
      <h1>Popular</h1>

      <form onSubmit={handleSubmit}>
        <input 
          type="text"
          required
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
        />
      </form>
      
      {error && <div>{error}</div>}
      {isPending && <div>Loading...</div>}
      {blogs && <BlogList blogs={blogs} title="Popular"/>}
    </div>
  );
};

export default Home;
