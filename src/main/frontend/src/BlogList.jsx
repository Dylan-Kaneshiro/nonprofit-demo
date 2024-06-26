import { Link } from "react-router-dom";
import blogIDToURL from "./Services/blogIDToURL";

const BlogList = ({blogs, title}) => {
    //const blogs = props.blogs;
    //const title = props.title;
    
    return ( 
        <div className="blog-list"> 
            {blogs.map(blog => (
                <div className="blog-preview" key={blog.id}>
                    <Link to={`/blogs/${blog.id}`}>
                        <h2>{blog.title}</h2>
                        <p>{blog.author}</p>
                        <p>{blog.city}</p>
                    </Link>
                </div>
            ))}
        </div>
     );
}
 
export default BlogList;