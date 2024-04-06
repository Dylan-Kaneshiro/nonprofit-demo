import useFetch from "../useFetch";

const useBlogs = () => {
    return useFetch('http://localhost:8000/blogs')
}

const blogIDToURL = (id) => {
    return `/blogs/${id}`
}

export default useBlogs;