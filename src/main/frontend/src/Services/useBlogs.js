import useFetch from "../useFetch";

const useBlogs = (searchTerm, city, sort="") => {
    
    return useFetch(`http://localhost:8086/blogs/search?searchParam=${searchTerm}`)
    // return useFetch(`http://localhost:8086/blogs/search?searchParam=${searchTerm}&city=${city}&sortBy=view_count`)
}

export default useBlogs;