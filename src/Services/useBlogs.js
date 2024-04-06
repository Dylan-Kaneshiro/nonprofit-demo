import useFetch from "../useFetch";

const useBlogs = (searchTerm) => {
    return useFetch(`http://localhost:8000/blogs?title=${searchTerm}`)
}

export default useBlogs;