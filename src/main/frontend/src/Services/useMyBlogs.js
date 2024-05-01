import useFetch from "../useFetch";

const useMyBlogs = (email) => {
  return useFetch(
    `http://localhost:8086/organizations/event-list/${email}`
  );
};

export default useMyBlogs;
