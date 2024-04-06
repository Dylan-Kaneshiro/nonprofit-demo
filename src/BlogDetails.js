import { useParams, useHistory } from "react-router-dom";
import useFetch from "./useFetch";
import blogIDToURL from "./Services/blogIDToURL";

const BlogDetails = () => {

    const { id } = useParams();
    const { data: blog, isPending, error } = useFetch(blogIDToURL(id))
    const history = useHistory();

    const handleClick = () => {
        fetch(blogIDToURL(blog.id), {
            method:'DELETE'
        }).then(() => {
            history.push('/')
        })
    }

    return ( 
        <div className="blog-details">
            {isPending && <div>Loading ...</div>}
            {error && <div>{error}</div>}
            {blog && (
                <article>
                    <h2>{blog.title}</h2>
                    <h3>By {blog.author}</h3>
                    <br />
                    <p><strong>Address: </strong> {blog.address}</p>
                    <p><strong>Hours: </strong> {blog.hours}</p>
                    <p><strong>Phone: </strong> {blog.phone}</p>
                    <p><strong>Email: </strong> {blog.email}</p>
                    <div>{blog.body}</div>
                    <button onClick={handleClick}>delete</button>
                </article>
            )}
        </div>
     );
}
 
export default BlogDetails;