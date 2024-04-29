import useFetch from "../useFetch";

const useBlogs = (searchTerm, city, sort = "view_count") => {
  return useFetch(
    `http://localhost:8086/blogs/search?searchParam=${searchTerm}&sortBy=${sort}&city=${city}`
  );
};

export default useBlogs;
