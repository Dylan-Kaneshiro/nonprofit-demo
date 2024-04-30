import useFetch from "../useFetch";

const useMyBlogs = (email) => {
  return useFetch(
    `http://localhost:8000/blogs`
  );
};

export default useMyBlogs;
