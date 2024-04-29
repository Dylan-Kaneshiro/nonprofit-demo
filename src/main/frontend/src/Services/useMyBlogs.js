import useFetch from "../useFetch";

const useMyBlogs = (email) => {
  return useFetch(
    `http://localhost:8086/blogs?email=${email}`
  );
};

export default useMyBlogs;
