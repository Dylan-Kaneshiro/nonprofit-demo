import useFetch from "../useFetch";

const useBlogs = (searchTerm, city, sort = "creation_date") => {
  return useFetch(
    `http://localhost:8086/blogs/search?searchParam=${searchTerm}&sortBy=${sort}&city=${city}`
  );
};

export default useBlogs;
