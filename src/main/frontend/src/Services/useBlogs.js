import useFetch from "../useFetch";

const useBlogs = (searchTerm) => {
    return useFetch(`http://localhost:8086/blogs/search?searchParam=${searchTerm}`)
}

export default useBlogs;