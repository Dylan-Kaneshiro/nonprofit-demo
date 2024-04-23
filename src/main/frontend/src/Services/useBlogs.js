import useFetch from "../useFetch";

const useBlogs = (searchTerm, city) => {
    return useFetch(`http://localhost:8086/blogs/search?searchParam=${searchTerm}`)
}

export default useBlogs;